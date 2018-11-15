package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.stickers.StickerSet;
import org.json.JSONObject;

public class StickerSetDecoder {

    public static StickerSet decode(JSONObject object) {
        return new StickerSet(object.getString("name"),
                object.getString("title"),
                StickerDecoder.decodeArray(object.getJSONArray("stickers")))
                .setContainsMask(object.optBoolean("contains_masks"));
    }
}
