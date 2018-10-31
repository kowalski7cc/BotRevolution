package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.payments.Invoice;
import org.json.JSONObject;

public class InvoiceDecoder {

    public static Invoice decode(JSONObject object) {
        return new Invoice(object.getString("title"),
                object.getString("description"),
                object.getString("start_parameter"),
                object.getString("currency"),
                object.getInt("total_amount"));
    }
}
