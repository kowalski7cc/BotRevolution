package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.media.PhotoSize;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class PhotoSizeDecoder {

    public static List<List<PhotoSize>> decodeArrayOfArray(JSONArray array) {
        var list = new LinkedList<List<PhotoSize>>();
        array.iterator().forEachRemaining(o -> list.add(decodeArray((JSONArray) o)));
        return list;
    }

    public static List<PhotoSize> decodeArray(JSONArray array) {
        var list = new LinkedList<PhotoSize>();
        array.iterator().forEachRemaining(o -> list.add(decode((JSONObject) o)));
        return list;
    }

    public static PhotoSize decode(JSONObject object) {
        return new PhotoSize(object.getString("file_id"), object.getInt("width"), object.getInt("height"))
                .setFileSize(object.optInt("file_size"));
    }
}
