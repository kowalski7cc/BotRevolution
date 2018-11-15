package com.kowalski7cc.botrevolution.utils.decoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseDecoder {

    public static String decodeString(JSONObject object) {
        if(object.getBoolean("ok")) {
            return object.getString("result");
        }
        throw new TelegramException(object);
    }

    public static Boolean decodeBoolean(JSONObject object) {
        if(object.getBoolean("ok")) {
            return object.getBoolean("result");
        }
        throw new TelegramException(object);
    }

    public static Integer decodeInteger(JSONObject object) {
        if(object.getBoolean("ok")) {
            return object.getInt("result");
        }
        throw new TelegramException(object);
    }

    public static JSONObject decode(JSONObject object) {
        if(object.getBoolean("ok")) {
            return object.getJSONObject("result");
        }
        throw new TelegramException(object);
    }

    public static JSONArray decodeArray(JSONObject object) {
        if(object.getBoolean("ok")) {
            return object.getJSONArray("result");
        }
        throw new TelegramException(object);
    }
}
