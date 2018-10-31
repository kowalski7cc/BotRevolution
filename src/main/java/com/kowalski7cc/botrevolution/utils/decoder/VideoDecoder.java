package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.Video;
import org.json.JSONObject;

public class VideoDecoder {

    public static Video decode(JSONObject object) {
        return new Video(object.getString("file_id"), object.getInt("width"), object.getInt("height"), object.getInt("duration"))
                .setMimeType(object.optString("mime_type"))
                .setFileSize(object.optInt("file_size"))
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
