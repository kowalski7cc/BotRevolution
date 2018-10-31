package com.kowalski7cc.botrevolution.receivers;

import com.kowalski7cc.botrevolution.types.Update;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.UpdateDecoder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PollingReceiver extends Receiver {

    private final Queue<Update> updates;
    private Integer lastOffset;
    private ReceiverWorker receiverWorker;
    private final static int DEFAULT_TIMEOUT = 20;

    public PollingReceiver(String token) {
        super(token);
        updates = new LinkedBlockingQueue<>();
    }

    public boolean isPolling() {
        return receiverWorker != null && receiverWorker.isAlive();
    }

    public void startPolling(Integer timeout) {
        if (receiverWorker != null && receiverWorker.isAlive())
            return;
        receiverWorker = new ReceiverWorker(this, timeout);
        receiverWorker.start();
    }

    public void stopPolling() {
        if (receiverWorker != null) {
            receiverWorker.interrupt();
        }
    }

    public void update() throws IOException {
        update(DEFAULT_TIMEOUT, lastOffset);
    }

    public Queue<Update> getUpdates() {
        return updates;
    }

    public void update(Integer timeout, Integer offset) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        if (timeout != null && timeout > 0) {
            parameters.put("timeout", timeout.toString());
        }
        if (offset != null && offset > 0) {
            parameters.put("offset", offset.toString());
        }
        List<Update> updates;

        var tgRequest = RequestHelper.buildUrl(token, BotMethod.GETUPDATES, parameters);
        var httpRequest = new Request.Builder().url(tgRequest).build();

        var client = new OkHttpClient.Builder()
                .connectTimeout(10 + timeout, TimeUnit.SECONDS)
                .readTimeout(10 + timeout, TimeUnit.SECONDS)
                .writeTimeout(10 + timeout, TimeUnit.SECONDS)
                .build();
        var response = client.newCall(httpRequest).execute();

        if (response.isSuccessful() && response.body() != null) {
            updates = UpdateDecoder.decodeArray(ResponseDecoder.decodeArray(new JSONObject(response.body().string())));
            if (updates.size()>0) {
                lastOffset = updates.get(updates.size() - 1).getUpdateID() + 1;
                synchronized (this.updates) {
                    this.updates.addAll(updates);
                    this.updates.notifyAll();
                }
            }
        }
    }

    public Integer getLastOffset() {
        return lastOffset;
    }

    public void setLastOffset(Integer lastOffset) {
        this.lastOffset = lastOffset;
    }

    public void startPolling() {
        startPolling(DEFAULT_TIMEOUT);
    }

    private class ReceiverWorker extends Thread {

        private PollingReceiver receiver;
        private Integer timeout;
        private boolean suppressExceptions;

        public ReceiverWorker(PollingReceiver receiver, Integer timeout) {
            setName("Telegram Bot Polling");
            this.receiver = receiver;
            this.timeout = timeout;
            setDaemon(true);
            suppressExceptions = true;
        }

        public ReceiverWorker setSuppressExceptions(boolean suppressExceptions) {
            this.suppressExceptions = suppressExceptions;
            return this;
        }

        @SuppressWarnings("ConstantConditions")
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    receiver.update(timeout + 10, receiver.lastOffset);
                } catch (IOException e) {
                    if (!(e instanceof UnknownHostException)||!(e instanceof SocketTimeoutException))
                        if(!suppressExceptions)
                            e.printStackTrace();
                }
            }
        }
    }
}