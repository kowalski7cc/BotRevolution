package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendSticker extends SendMedia {

    private String chatID;
    private Object sticker;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendSticker(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendSticker setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendSticker setSticker(Object sticker) {
        this.sticker = Objects.requireNonNull(sticker);
        return this;
    }

    public SendSticker setDisableNotification(Boolean disableNotification) {
        this.disableNotification = Objects.requireNonNull(disableNotification);
        return this;
    }

    public SendSticker setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = Objects.requireNonNull(replyToMessageID);
        return this;
    }

    public SendSticker setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = Objects.requireNonNull(replyMarkup);
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        if (replyToMessageID != null) {
            parameters.put("reply_to_message_id", Integer.toString(replyToMessageID));
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(sticker, parameters, BotMethod.SENDSTICKER, "sticker");
    }
}
