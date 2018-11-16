package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.UpdateType;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import org.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class SetWebhook extends MethodBuilder<Boolean> {

    private String url;
    private File certificate;
    private Integer maxConection;
    private List<UpdateType> allowedUpdates;

    public SetWebhook(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetWebhook setUrl(String url) {
        this.url = Objects.requireNonNull(url);
        return this;
    }

    public SetWebhook setCertificate(File certificate) {
        this.certificate = certificate;
        return this;
    }

    public SetWebhook setMaxConection(Integer maxConection) {
        this.maxConection = maxConection;
        return this;
    }

    public SetWebhook setAllowedUpdates(List<UpdateType> allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("url", Objects.requireNonNull(url));
        if(maxConection != null)
            parameters.put("max_connections", maxConection.toString());
        if(allowedUpdates != null) {
            parameters.put("allowed_updates", new JSONArray(allowedUpdates).toString());
        }
        if (certificate == null) {
            return RequestHelper.get(token, BotMethod.SETWEBHOOK, parameters, timeout)
                    .map(ResponseDecoder::decodeBoolean);
        } else {
            String url = RequestHelper.buildUrl(token, BotMethod.SETWEBHOOK, parameters);
            Map<String, Object> payload = new HashMap<>();
            payload.put("certificate", certificate);
            try {
                return Optional.of(
                        ResponseDecoder.decodeBoolean(
                                RequestHelper.postMedia(url, payload, timeout)
                        ));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return Optional.empty();
            } catch (IOException e) {
                return Optional.empty();
            }
        }
    }

}
