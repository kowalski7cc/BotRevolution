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

public class SendContact extends MethodBuilder<Message> {

    private String chatID;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String vcard;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendContact(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendContact setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendContact setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendContact setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendContact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SendContact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public SendContact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public SendContact setVcard(String vcard) {
        this.vcard = vcard;
        return this;
    }

    public SendContact setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendContact setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendContact setReplyToMessageID(Message message) {
        this.replyToMessageID = message.getMessageID();
        return this;
    }

    public SendContact setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("phone_number", Objects.requireNonNull(phoneNumber));
        parameters.put("first_name", Objects.requireNonNull(firstName));
        if (lastName != null)
            parameters.put("last_name", lastName);
        if (vcard != null)
            parameters.put("vcard", vcard);
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
