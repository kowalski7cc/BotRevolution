package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard.InlineKeyboardMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EditMessageReplyMarkup extends MethodBuilder<Message> {

    private String chatID;
    private Integer messageID;
    private String inlineMessageID;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageReplyMarkup(String token, Integer timeout) {
        super(token, timeout);
    }

    public EditMessageReplyMarkup setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public EditMessageReplyMarkup setMessageID(Integer messageID) {
        this.messageID = Objects.requireNonNull(messageID);
        return this;
    }

    public EditMessageReplyMarkup setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = Objects.requireNonNull(inlineMessageID);
        return this;
    }

    public EditMessageReplyMarkup setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
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
        parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.EDITMESSAGEREPLYMARKUP, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
