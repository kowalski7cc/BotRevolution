package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.payments.ShippingAddress;
import org.json.JSONObject;

public class ShippingAddressDecoder {

    public static ShippingAddress decode(JSONObject object) {
        return new ShippingAddress(object.getString("country_code"),
                object.getString("state"),
                object.getString("city"),
                object.getString("street_line1"),
                object.getString("street_line2"),
                object.getString("post_code"));
    }
}
