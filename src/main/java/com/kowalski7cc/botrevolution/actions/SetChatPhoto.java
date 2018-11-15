package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SetChatPhoto extends MethodBuilder<Boolean> {

    private String chatID;
    private File photo;

    public SetChatPhoto(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetChatPhoto setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SetChatPhoto setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SetChatPhoto setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SetChatPhoto setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        String url = RequestHelper.buildUrl(token, BotMethod.SETCHATPHOTO, parameters);
        Map<String, Object> payload = new HashMap<>();
        payload.put("photo", photo);
        try {
            return Optional.of(ResponseDecoder.decodeBoolean(
                    RequestHelper.postMedia(url, payload, timeout)
            ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ignored) {
        }
        return Optional.empty();
    }
}
