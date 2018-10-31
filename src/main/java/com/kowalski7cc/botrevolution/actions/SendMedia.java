package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.media.Media;
import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class SendMedia extends MethodBuilder<Message> {

    public SendMedia(String token, Integer timeout) {
        super(token, timeout);
    }

    protected Optional<Message> sendMedia(Object object, Map<String, String> parameters, BotMethod botMethod, String type, Object thumb) {
        Objects.requireNonNull(object);
        if (object instanceof  String) {
            parameters.put(type, (String) object);
        } else if (object instanceof Media) {
            parameters.put(type, ((Media) object).getFileID());
        } else if (object instanceof Sticker) {
            parameters.put(type, ((Sticker) object).getFileID());
        } else if (object instanceof URL) {
            parameters.put(type, object.toString());
        } else if (object instanceof File) {
            String url = RequestHelper.buildUrl(token, botMethod, parameters);
            Map<String, Object> payload = new HashMap<>();
            payload.put(type, object);
            if (thumb != null)
                payload.put("thumb", thumb);
            try {
                //response = RequestHelper.postFile(url, (File) object, timeout, type);
                return Optional.of(MessageDecoder.decode(
                        ResponseDecoder.decode(
                                RequestHelper.postMedia(url, payload, timeout)
                        )
                ));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                return Optional.empty();
            }
        } else {
            throw new IllegalArgumentException("object must be Sticker, URL, Media, File or String");
        }
        return RequestHelper.get(token, botMethod, parameters, timeout)
                .map(payload -> MessageDecoder.decode(ResponseDecoder.decode(payload)));
    }

    protected Optional<Message> sendMedia(Object object, Map<String, String> parameters, BotMethod botMethod, String type) {
        return  sendMedia(object, parameters, botMethod, type, null);
    }
}
