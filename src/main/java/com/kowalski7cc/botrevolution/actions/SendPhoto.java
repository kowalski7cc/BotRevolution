package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.ParseMode;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendPhoto extends SendMedia {

    private String chatID;
    private Object photo;
    private String caption;
    private ParseMode parseMode;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendPhoto(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendPhoto setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendPhoto setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendPhoto setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendPhoto setPhoto(Object photo) {
        this.photo = photo;
        return this;
    }

    public SendPhoto setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendPhoto setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendPhoto setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendPhoto setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendPhoto setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendPhoto setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        if (caption != null ) {
            parameters.put("caption", caption);
        }
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        if (replyToMessageID != null) {
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        }
        if (parseMode != null) {
            parameters.put("parse_mode", parseMode.toString());
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(photo, parameters, BotMethod.SENDPHOTO, "photo");
    }
}
