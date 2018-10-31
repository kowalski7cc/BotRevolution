package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendVenue extends MethodBuilder<Message> {

    private String chatID;
    private Float latitude;
    private Float longitude;
    private String title;
    private String address;
    private String foursquareID;
    private String foursquareType;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendVenue(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendVenue setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendVenue setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public SendVenue setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public SendVenue setTitle(String title) {
        this.title = title;
        return this;
    }

    public SendVenue setAddress(String address) {
        this.address = address;
        return this;
    }

    public SendVenue setFoursquareID(String foursquareID) {
        this.foursquareID = foursquareID;
        return this;
    }

    public SendVenue setFoursquareType(String foursquareType) {
        this.foursquareType = foursquareType;
        return this;
    }

    public SendVenue setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendVenue setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendVenue setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("latitude", Objects.requireNonNull(latitude.toString()));
        parameters.put("longitude", Objects.requireNonNull(longitude.toString()));
        parameters.put("title", Objects.requireNonNull(title));
        parameters.put("address", Objects.requireNonNull(address));
        if (foursquareID != null)
            parameters.put("foursquare_id", foursquareID);
        if (foursquareType != null)
            parameters.put("foursquare_type", foursquareType);
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        if (replyToMessageID != null)
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.SENDVENUE, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
