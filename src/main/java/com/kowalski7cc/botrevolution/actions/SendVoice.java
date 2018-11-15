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

public class SendVoice extends SendMedia {

    private String chatID;
    private Object voice;
    private String caption;
    private ParseMode parseMode;
    private Integer duration;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendVoice(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendVoice setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendVoice setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public SendVoice setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public SendVoice setVoice(Object voice) {
        this.voice = Objects.requireNonNull(voice);
        return this;
    }

    public SendVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendVoice setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendVoice setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendVoice setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendVoice setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendVoice setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendVoice setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        if (replyToMessageID != null) {
            parameters.put("reply_to_message_id", Integer.toString(replyToMessageID));
        }
        if (parseMode != null ) {
            parameters.put("parse_mode", parseMode.toString());
        }
        if (caption != null ) {
            parameters.put("caption", caption);
        }
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        if (duration != null) {
            parameters.put("duration", duration.toString());
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(voice, parameters, BotMethod.SENDVOICE, "voice");
    }
}
