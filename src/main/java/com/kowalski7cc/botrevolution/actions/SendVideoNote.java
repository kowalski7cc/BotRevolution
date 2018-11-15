package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendVideoNote extends SendMedia {

    private String chatID;
    private Object videoNote;
    private Integer duration;
    private Integer length;
    private Object thumb;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendVideoNote(String token, Integer timeout) {
        super(token, timeout);
    }

    public String getChatID() {
        return chatID;
    }

    public SendVideoNote setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendVideoNote setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public SendVideoNote setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public SendVideoNote setVideoNote(Object videoNote) {
        this.videoNote = Objects.requireNonNull(videoNote);
        return this;
    }

    public SendVideoNote setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendVideoNote setLength(Integer length) {
        this.length = length;
        return this;
    }

    public SendVideoNote setThumb(Object thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendVideoNote setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendVideoNote setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendVideoNote setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendVideoNote setReplyMarkup(ReplyMarkup replyMarkup) {
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
        if (duration != null ) {
            parameters.put("duration", duration.toString());
        }
        if (length != null ) {
            parameters.put("length", length.toString());
        }
        if (disableNotification != null) {
            parameters.put("disable_notification", disableNotification.toString());
        }
        if (duration != null) {
            parameters.put("duration", duration.toString());
        }
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return sendMedia(videoNote, parameters, BotMethod.SENDVIDEONOTE, "video_note", thumb);
    }
}
