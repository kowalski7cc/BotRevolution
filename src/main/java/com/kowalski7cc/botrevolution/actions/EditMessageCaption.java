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

public class EditMessageCaption extends MethodBuilder<Message> {

    private String chatID;
    private Integer messageID;
    private String inlineMessageID;
    private String caption;
    private ParseMode parseMode;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageCaption(String token, Integer timeout) {
        super(token, timeout);
    }

    public EditMessageCaption setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public EditMessageCaption setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public EditMessageCaption setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public EditMessageCaption setMessageID(Integer messageID) {
        this.messageID = Objects.requireNonNull(messageID);
        return this;
    }

    public EditMessageCaption setMessageID(Message message) {
        this.messageID = Objects.requireNonNull(message.getMessageID());
        return this;
    }

    public EditMessageCaption setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = Objects.requireNonNull(inlineMessageID);
        return this;
    }

    public EditMessageCaption setCaption(String caption) {
        this.caption = Objects.requireNonNull(caption);
        return this;
    }

    public EditMessageCaption setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public EditMessageCaption setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
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
        parameters.put("caption", caption);
        parameters.put("parse_mode", parseMode.toString());
        parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.EDITMESSAGECAPTION, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
