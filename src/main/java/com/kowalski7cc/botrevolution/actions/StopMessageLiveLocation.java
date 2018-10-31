package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.inlinekeyboard.InlineKeyboardMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class StopMessageLiveLocation extends MethodBuilder<Message> {

    private String chatID;
    private Integer messageID;
    private String inlineMessageID;
    private InlineKeyboardMarkup replyMarkup;

    public StopMessageLiveLocation setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public StopMessageLiveLocation setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public StopMessageLiveLocation setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public StopMessageLiveLocation setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public StopMessageLiveLocation setMessageID(Message message) {
        this.messageID = message.getMessageID();
        return this;
    }

    public StopMessageLiveLocation setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    public StopMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public StopMessageLiveLocation(String token, Integer timeout) {
        super(token, timeout);
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
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.STOPMESSAGELIVELOCATION, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
