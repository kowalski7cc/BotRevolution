package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DeleteMessage extends MethodBuilder<Boolean>  {

    private String chatID;
    private Integer messageID;

    public DeleteMessage(String token, Integer timeout) {
        super(token, timeout);
    }

    public DeleteMessage setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public DeleteMessage setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public DeleteMessage setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public DeleteMessage setMessageID(Integer messageID) {
        this.messageID = Objects.requireNonNull(messageID);
        return this;
    }

    public DeleteMessage setMessageID(Message message) {
        this.messageID = Objects.requireNonNull(message.getMessageID());
        return this;
    }

    public DeleteMessage setMessage(Message message) {
        this.messageID = Objects.requireNonNull(message.getMessageID());
        this.chatID = Objects.requireNonNull(message.getChat().getId().toString());
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("message_id", Objects.requireNonNull(messageID.toString()));
        return RequestHelper.get(token, BotMethod.DELETEMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
