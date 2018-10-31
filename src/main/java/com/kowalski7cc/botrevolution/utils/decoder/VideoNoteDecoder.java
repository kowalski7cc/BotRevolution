package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.VideoNote;
import org.json.JSONObject;

public class VideoNoteDecoder {

    public static VideoNote decode(JSONObject object) {
        return new VideoNote(object.getString("file_id"), object.getInt("length"), object.getInt("duration"))
                .setFileSize(object.optInt("file_size"))
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
