package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.Audio;
import org.json.JSONObject;

public class AudioDecoder {

    public static Audio decode(JSONObject object) {
        return new Audio(object.getString("file_id"), object.getInt("duration"))
                .setPerformer(object.optString("performer"))
                .setTitle(object.optString("title"))
                .setMimeType(object.optString("mime_type"))
                .setFileSize(object.optInt("file_size"))
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
