package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Update;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class UpdateDecoder {

    public static List<Update> decodeArray(JSONArray array) {
        var list = new LinkedList<Update>();
        array.iterator().forEachRemaining(a -> list.add(decode((JSONObject) a)));
        return list;
    }

    public static Update decode(JSONObject object) {
        return new Update(object.getInt("update_id"))
                .setMessage(object.has("message")?MessageDecoder.decode(object.getJSONObject("message")):null)
                .setEditedMessage(object.has("edited_message")?MessageDecoder.decode(object.getJSONObject("edited_message")):null)
                .setChannelPost(object.has("channel_post")?MessageDecoder.decode(object.getJSONObject("channel_post")):null)
                .setEditedChannelPost(object.has("edited_channel_post")?MessageDecoder.decode(object.getJSONObject("edited_channel_post")):null)
                .setInlineQuery(null)
                .setChosenInlineResult(null)
                .setCallbackQuery(null)
                .setShippingQuery(null)
                .setPreCheckoutQuery(null);
    }
}
