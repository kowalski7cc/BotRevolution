package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ForwardMessage extends MethodBuilder<Message> {

    private String chatID;
    private String fromChatID;
    private Boolean disableNotification;
    private Integer messageID;

    public ForwardMessage(String token, Integer timeout) {
        super(token, timeout);
    }

    public ForwardMessage setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public ForwardMessage setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public ForwardMessage setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public ForwardMessage setFromChatID(String fromChatID) {
        this.fromChatID = fromChatID;
        return this;
    }

    public ForwardMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public ForwardMessage setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("from_chat_id", Objects.requireNonNull(fromChatID));
        parameters.put("message_id", Integer.toString(Objects.requireNonNull(messageID)));
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        return RequestHelper.get(token, BotMethod.FORWARDMESSAGE, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
