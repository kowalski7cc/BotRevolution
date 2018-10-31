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

public class SendDocument extends SendMedia {

    private String chatID;
    private Object document;
    private Object thumb;
    private String caption;
    private ParseMode parseMode;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendDocument(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendDocument setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendDocument setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendDocument setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendDocument setDocument(Object document) {
        this.document = document;
        return this;
    }

    public SendDocument setThumb(Object thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendDocument setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendDocument setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendDocument setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendDocument setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendDocument setReplyMarkup(ReplyMarkup replyMarkup) {
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
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        if (replyToMessageID != null) {
            parameters.put("reply_to_message_id", Integer.toString(replyToMessageID));
        }
        if (parseMode != null) {
            parameters.put("parse_mode", parseMode.toString());
        }
        return sendMedia(document, parameters, BotMethod.SENDDOCUMENT, "document", thumb);
    }
}
