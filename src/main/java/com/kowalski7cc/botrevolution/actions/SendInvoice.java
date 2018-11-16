package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.payments.LabeledPrice;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import org.json.JSONArray;

import java.util.*;

public class SendInvoice extends MethodBuilder<Message> {

    private Integer chatID;
    private String title;
    private String description;
    private String payload;
    private String providerToken;
    private String startParameter;
    private String currency;
    private List<LabeledPrice> prices;
    private String providerData;
    private String photoUrl;
    private Integer photoSize;
    private Integer photoWidth;
    private Integer photoHeight;
    private Boolean needName;
    private Boolean needPhoneNumber;
    private Boolean needEmail;
    private Boolean needShippingAddress;
    private Boolean sendPhoneNumberToProvider;
    private Boolean sendEmailToProvider;
    private Boolean isFlexible;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendInvoice(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendInvoice setChatID(Integer chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendInvoice setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public SendInvoice setDescription(String description) {
        this.description = Objects.requireNonNull(description);
        return this;
    }

    public SendInvoice setPayload(String payload) {
        this.payload = Objects.requireNonNull(payload);
        return this;
    }

    public SendInvoice setProviderToken(String providerToken) {
        this.providerToken = Objects.requireNonNull(providerToken);
        return this;
    }

    public SendInvoice setStartParameter(String startParameter) {
        this.startParameter = Objects.requireNonNull(startParameter);
        return this;
    }

    public SendInvoice setCurrency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    public SendInvoice setPrices(List<LabeledPrice> prices) {
        this.prices = Objects.requireNonNull(prices);
        return this;
    }

    public SendInvoice setProviderData(String providerData) {
        this.providerData = providerData;
        return this;
    }

    public SendInvoice setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public SendInvoice setPhotoSize(Integer photoSize) {
        this.photoSize = photoSize;
        return this;
    }

    public SendInvoice setPhotoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    public SendInvoice setPhotoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    public SendInvoice setNeedName(Boolean needName) {
        this.needName = needName;
        return this;
    }

    public SendInvoice setNeedPhoneNumber(Boolean needPhoneNumber) {
        this.needPhoneNumber = needPhoneNumber;
        return this;
    }

    public SendInvoice setNeedEmail(Boolean needEmail) {
        this.needEmail = needEmail;
        return this;
    }

    public SendInvoice setNeedShippingAddress(Boolean needShippingAddress) {
        this.needShippingAddress = needShippingAddress;
        return this;
    }

    public SendInvoice setSendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        return this;
    }

    public SendInvoice setSendEmailToProvider(Boolean sendEmailToProvider) {
        this.sendEmailToProvider = sendEmailToProvider;
        return this;
    }

    public SendInvoice setFlexible(Boolean flexible) {
        isFlexible = flexible;
        return this;
    }

    public SendInvoice setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendInvoice setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendInvoice setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", chatID.toString());
        parameters.put("title", title);
        parameters.put("description", description);
        parameters.put("payload", payload);
        parameters.put("provider_token", providerToken);
        parameters.put("start_parameter", startParameter);
        parameters.put("currency", currency);
        parameters.put("prices", new JSONArray(prices.stream()
                .map(LabeledPrice::serializeJSON))
                .toString());
        if (providerData != null) {
            parameters.put("provider_data", providerData);
        }
        if (photoUrl != null) {
            parameters.put("photo_url", photoUrl);
        }
        if (photoSize != null) {
            parameters.put("photo_size", photoSize.toString());
        }
        if (photoWidth != null) {
            parameters.put("photo_width", photoWidth.toString());
        }
        if (photoHeight != null) {
            parameters.put("photo_height", photoHeight.toString());
        }
        if (needName != null) {
            parameters.put("need_name", needName.toString());
        }
        if (needPhoneNumber != null) {
            parameters.put("need_phone_number", needPhoneNumber.toString());
        }
        if (needEmail != null) {
            parameters.put("need_email", needEmail.toString());
        }
        if (needShippingAddress != null) {
            parameters.put("need_shipping_address", needShippingAddress.toString());
        }
        if (sendPhoneNumberToProvider != null) {
            parameters.put("send_phone_number_to_provider", sendPhoneNumberToProvider.toString());
        }
        if (sendEmailToProvider != null) {
            parameters.put("send_email_to_provider", sendEmailToProvider.toString());
        }
        if (isFlexible != null) {
            parameters.put("is_flexible", isFlexible.toString());
        }
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        if (replyToMessageID != null)
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.SENDINVOICE, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}