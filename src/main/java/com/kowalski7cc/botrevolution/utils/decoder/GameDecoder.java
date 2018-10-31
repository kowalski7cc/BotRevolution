package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.games.Game;
import org.json.JSONObject;

public class GameDecoder {

    public static Game decode(JSONObject object) {
        return new Game(object.getString("title"),
                object.getString("description"),
                PhotoSizeDecoder.decodeArray(object.getJSONArray("photo")))
                .setText(object.optString("text"))
                .setAnimation(object.has("animation")?AnimationDecoder.decode(object.getJSONObject("animation")):null)
                .setTextEntities(object.has("text_entities")?MessageEntityDecoder.decodeArray(object.getJSONArray("text_entities")):null);
    }
}
