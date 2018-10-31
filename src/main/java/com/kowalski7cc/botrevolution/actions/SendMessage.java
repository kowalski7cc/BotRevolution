package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.ParseMode;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendMessage extends MethodBuilder<Message> {

    private String chatID;
    private String text;
    private ParseMode parseMode;
    private Boolean disableWebPagePreview;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendMessage(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendMessage setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendMessage setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendMessage setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendMessage setText(String text) {
        this.text = text;
        return this;
    }

    public SendMessage setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public SendMessage setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendMessage setReplyToMessage(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendMessage setReplyToMessage(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendMessage setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("text", Objects.requireNonNull(text));
        if (parseMode != null)
            parameters.put("parse_mode", parseMode.toString());
        if (disableWebPagePreview != null)
            parameters.put("disable_web_page_preview", disableWebPagePreview.toString());
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        if (replyToMessageID != null)
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.SENDMESSAGE, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }

}
