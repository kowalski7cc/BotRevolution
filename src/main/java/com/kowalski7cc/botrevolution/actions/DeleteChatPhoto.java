package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DeleteChatPhoto extends MethodBuilder<Boolean> {

    private String chatID;

    public DeleteChatPhoto(String token, Integer timeout) {
        super(token, timeout);
    }

    public DeleteChatPhoto setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public DeleteChatPhoto setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public DeleteChatPhoto setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        return RequestHelper.get(token, BotMethod.DELETECHATPHOTO, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
