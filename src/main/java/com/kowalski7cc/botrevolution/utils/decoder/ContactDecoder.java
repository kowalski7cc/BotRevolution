package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Contact;
import org.json.JSONObject;

public class ContactDecoder {

    public static Contact decode(JSONObject object) {
        return new Contact(object.getString("phone_number"), object.getString("first_name"))
                .setLastName(object.optString("last_name"))
                .setUserID(object.optInt("user_id"))
                .setVcard(object.optString("vcard"));
    }
}
