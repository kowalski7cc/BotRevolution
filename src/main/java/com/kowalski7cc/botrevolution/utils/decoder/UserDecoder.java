package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class UserDecoder {

    public static List<User> decodeArray(JSONArray array) {
        var list = new LinkedList<User>();
        array.iterator().forEachRemaining(o -> list.add(decode((JSONObject) o)));
        return list;
    }

    public static User decode(JSONObject object) {
        return new User(object.getInt("id"), object.getBoolean("is_bot"), object.getString("first_name"))
                .setLastName(object.optString("last_name"))
                .setLanguageCode(object.optString("language_code"))
                .setUsername(object.optString("username"));
    }
}
