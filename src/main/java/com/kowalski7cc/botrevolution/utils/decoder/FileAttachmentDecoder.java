package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.FileAttachment;
import org.json.JSONObject;

public class FileAttachmentDecoder {

    public static FileAttachment decode(JSONObject object) {
        return new FileAttachment(object.getString("file_id"))
                .setFileSize(object.optInt("file_size"))
                .setFilePath(object.optString("file_path"));
    }
}
