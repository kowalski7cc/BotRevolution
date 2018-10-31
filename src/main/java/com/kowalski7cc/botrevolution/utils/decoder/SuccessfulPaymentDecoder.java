package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.payments.SuccessfulPayment;
import org.json.JSONObject;

public class SuccessfulPaymentDecoder {

    public static SuccessfulPayment decode(JSONObject object) {
        return new SuccessfulPayment(object.getString("currency"),
                object.getInt("total_amount"),
                object.getString("invoice_payload"),
                object.getString("telegram_payment_charge_id"),
                object.getString("provider_payment_charge_id"))
                .setShippingOptionID(object.optString("shipping_option_id"))
                .setOrderInfo(object.has("order_info")? OrderInfoDecoder.decode(object.getJSONObject("order_info")):null);
    }
}
