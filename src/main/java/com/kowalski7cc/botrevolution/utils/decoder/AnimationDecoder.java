package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.Animation;
import org.json.JSONObject;

public class AnimationDecoder {

    public static Animation decode(JSONObject object) {
        return new Animation(object.getString("file_id"), object.getInt("width"), object.getInt("height"), object.getInt("duration"))
                .setFileName(object.optString("file_name"))
                .setMimeType(object.optString("mime_type"))
                .setFileSize(object.optInt("file_size"))
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
