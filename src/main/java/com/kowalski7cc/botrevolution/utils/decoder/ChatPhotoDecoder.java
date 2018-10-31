package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.chat.ChatPhoto;
import org.json.JSONObject;

public class ChatPhotoDecoder {

    public static ChatPhoto decode(JSONObject object) {
        return new ChatPhoto(object.getString("small_file_id"), object.getString("big_file_id"));
    }
}
