package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
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

public class SendLocation extends MethodBuilder<Message> {

    private String chatID;
    private Float latitude;
    private Float longitude;
    private Integer livePeriod;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendLocation(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendLocation setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendLocation setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendLocation setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public SendLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public SendLocation setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }

    public SendLocation setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendLocation setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendLocation setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendLocation setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("latitude", Objects.requireNonNull(latitude.toString()));
        parameters.put("longitude", Objects.requireNonNull(longitude.toString()));
        if (livePeriod != null)
            parameters.put("parse_mode", livePeriod.toString());
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        if (replyToMessageID != null)
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.SENDLOCATION, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
