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

public class SendAnimation extends SendMedia {

    private String chatID;
    private Object animation;
    private Integer duration;
    private Integer width;
    private Integer height;
    private Object thumb;
    private String caption;
    private ParseMode parseMode;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendAnimation(String token, Integer timeout) {
        super(token, timeout);
    }

    public String getChatID() {
        return chatID;
    }

    public SendAnimation setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendAnimation setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public SendAnimation setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public SendAnimation setAnimation(Object animation) {
        this.animation = Objects.requireNonNull(animation);
        return this;
    }

    public SendAnimation setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendAnimation setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public SendAnimation setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public SendAnimation setThumb(Object thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendAnimation setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendAnimation setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendAnimation setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendAnimation setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendAnimation setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendAnimation setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        if (parseMode != null ) {
            parameters.put("parse_mode", parseMode.toString());
        }
        if (caption != null ) {
            parameters.put("caption", caption);
        }
        if (height != null) {
            parameters.put("height", height.toString());
        }
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        if (replyToMessageID != null) {
            parameters.put("reply_to_message_id", Integer.toString(replyToMessageID));
        }
        if (width != null) {
            parameters.put("width", width.toString());
        }
        if (duration != null) {
            parameters.put("duration", duration.toString());
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(animation, parameters, BotMethod.SENDANIMATION, "animation", thumb);
    }
}
