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

public class SendAudio extends SendMedia {

    private String chatID;
    private Object audio;
    private String caption;
    private ParseMode parseMode;
    private Integer duration;
    private String performer;
    private String title;
    private Object thumb;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendAudio(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendAudio setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendAudio setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendAudio setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendAudio setAudio(Object audio) {
        this.audio = audio;
        return this;
    }

    public SendAudio setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendAudio setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendAudio setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public SendAudio setTitle(String title) {
        this.title = title;
        return this;
    }

    public SendAudio setThumb(Object thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendAudio setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendAudio setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendAudio setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendAudio setReplyMarkup(ReplyMarkup replyMarkup) {
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
            parameters.put("reply_to_message_id", Integer.toString(replyToMessageID));
        }
        if (parseMode != null) {
            parameters.put("parse_mode", parseMode.toString());
        }
        if (duration != null) {
            parameters.put("duration", duration.toString());
        }
        if (performer != null) {
            parameters.put("performer", performer);
        }
        if (title != null) {
            parameters.put("title", title);
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(audio, parameters, BotMethod.SENDAUDIO, "audio", thumb);
    }
}
