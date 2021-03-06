package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UnpinChatMessage extends MethodBuilder<Boolean> {

    private String chatID;

    public UnpinChatMessage(String token, Integer timeout) {
        super(token, timeout);
    }

    public String getChatID() {
        return chatID;
    }

    public UnpinChatMessage setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public UnpinChatMessage setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public UnpinChatMessage setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        return RequestHelper.get(token, BotMethod.UNPINCHATMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
