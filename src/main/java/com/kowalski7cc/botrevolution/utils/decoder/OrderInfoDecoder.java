package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.payments.OrderInfo;
import org.json.JSONObject;

public class OrderInfoDecoder {

    public static OrderInfo decode(JSONObject object) {
        return new OrderInfo()
                .setName(object.optString("name"))
                .setPhoneNumber(object.optString("phone_number"))
                .setEmail(object.optString("email"))
                .setShippingAddress(object.has("shipping_address")?ShippingAddressDecoder.decode(object.getJSONObject("shipping_address")):null);
    }
}
