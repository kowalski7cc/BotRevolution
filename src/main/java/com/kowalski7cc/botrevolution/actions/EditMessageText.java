package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.ParseMode;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard.InlineKeyboardMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EditMessageText extends MethodBuilder<Message> {

    private String chatID;
    private Integer messageID;
    private String inlineMessageID;
    private String text;
    private ParseMode parseMode;
    private Boolean disableNotification;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageText(String token, Integer timeout) {
        super(token, timeout);
    }

    public EditMessageText setText(String text) {
        this.text = Objects.requireNonNull(text);
        return this;
    }

    public EditMessageText setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public EditMessageText setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public EditMessageText setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public EditMessageText setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public EditMessageText setMessageID(Message message) {
        this.messageID = message.getMessageID();
        return this;
    }

    public EditMessageText setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    public EditMessageText setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public EditMessageText setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public EditMessageText setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        if (chatID != null && messageID != null) {
            parameters.put("chat_id", Objects.requireNonNull(chatID));
            parameters.put("message_id", Objects.requireNonNull(messageID.toString()));
        } else if (inlineMessageID != null) {
            parameters.put("inline_message_id", Objects.requireNonNull(inlineMessageID));
        } else {
            throw new IllegalArgumentException("You must provide chatID and messageID or inlineMessageID");
        }
        parameters.put("text", text);
        parameters.put("parse_mode", parseMode.toString());
        parameters.put("disable_web_page_preview", disableNotification.toString());
        parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.EDITMESSAGETEXT, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
