package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.Document;
import org.json.JSONObject;

public class DocumentDecoder {

    public static Document decode(JSONObject object) {
        return new Document(object.getString("file_id"))
                .setFileName(object.optString("file_name"))
                .setMimeType(object.optString("mime_type"))
                .setFileSize(object.optInt("file_size"))
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
