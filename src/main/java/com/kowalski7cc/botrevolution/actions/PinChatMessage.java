package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PinChatMessage extends MethodBuilder<Boolean> {

    private String chatID;
    private Integer messageID;
    private Boolean disableNotification;

    public PinChatMessage(String token, Integer timeout) {
        super(token, timeout);
    }

    public String getChatID() {
        return chatID;
    }

    public PinChatMessage setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public PinChatMessage setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public PinChatMessage setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public PinChatMessage setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public PinChatMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("message_id", Objects.requireNonNull(messageID.toString()));
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        return RequestHelper.get(token, BotMethod.PINCHATMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
