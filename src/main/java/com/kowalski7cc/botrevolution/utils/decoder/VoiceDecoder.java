package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.Voice;
import org.json.JSONObject;

public class VoiceDecoder {

    public static Voice decode(JSONObject object) {
        return new Voice(object.getString("file_id"), object.getInt("duration"))
                .setMimeType(object.optString("mime_type"))
                .setFileSize(object.optInt("file_size"));
    }
}
