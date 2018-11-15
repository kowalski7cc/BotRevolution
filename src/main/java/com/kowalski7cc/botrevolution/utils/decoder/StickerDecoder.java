package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class StickerDecoder {

    public static List<Sticker> decodeArray(JSONArray array) {
        List<Sticker> stickers = new LinkedList<>();
        array.forEach(o -> stickers.add(decode((JSONObject) o)));
        return stickers;
    }

    public static Sticker decode(JSONObject object) {
        return new Sticker(object.getString("file_id"), object.getInt("width"), object.getInt("height"))
                .setEmoji(object.optString("emoji"))
                .setFileSize(object.optInt("file_size"))
                .setSetName(object.optString("set_name"))
                .setMaskPosition(object.has("mask_position")? MaskPositionDecoder.decode(object.getJSONObject("mask_position")):null)
                .setThumb(object.has("thumb")?PhotoSizeDecoder.decode(object.getJSONObject("thumb")):null);
    }
}
