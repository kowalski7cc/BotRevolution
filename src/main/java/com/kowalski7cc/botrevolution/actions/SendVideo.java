package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.ParseMode;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendVideo extends SendMedia {

    private String chatID;
    private Object video;
    private Integer duration;
    private Integer width;
    private Integer height;
    private Object thumb;
    private String caption;
    private ParseMode parseMode;
    private Boolean supportsStreaming;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendVideo(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendVideo setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendVideo setVideo(Object video) {
        this.video = video;
        return this;
    }

    public SendVideo setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendVideo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public SendVideo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public SendVideo setThumb(Object thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendVideo setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendVideo setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendVideo setSupportsStreaming(Boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
        return this;
    }

    public SendVideo setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendVideo setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendVideo setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        if (supportsStreaming != null) {
            parameters.put("supports_streaming", supportsStreaming.toString());
        }
        if (caption != null ) {
            parameters.put("caption", caption);
        }
        if (duration != null) {
            parameters.put("duration", duration.toString());
        }
        if (width != null) {
            parameters.put("width", width.toString());
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
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        if (parseMode != null) {
            parameters.put("parse_mode", parseMode.toString());
        }
        return sendMedia(video, parameters, BotMethod.SENDVIDEO, "video", thumb);
    }
}
