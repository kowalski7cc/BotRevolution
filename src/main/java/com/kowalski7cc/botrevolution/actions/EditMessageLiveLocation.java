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

public class EditMessageLiveLocation extends MethodBuilder<Message> {

    private String chatID;
    private Integer messageID;
    private String inlineMessageID;
    private Float latitude;
    private Float longitude;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageLiveLocation(String token, Integer timeout) {
        super(token, timeout);
    }

    public EditMessageLiveLocation setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public EditMessageLiveLocation setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public EditMessageLiveLocation setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public EditMessageLiveLocation setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public EditMessageLiveLocation setMessageID(Message message) {
        this.messageID = message.getMessageID();
        return this;
    }

    public EditMessageLiveLocation setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    public EditMessageLiveLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public EditMessageLiveLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public EditMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
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
        parameters.put("latitude", Objects.requireNonNull(latitude.toString()));
        parameters.put("longitude", Objects.requireNonNull(longitude.toString()));
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.EDITMESSAGELIVELOCATION, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
