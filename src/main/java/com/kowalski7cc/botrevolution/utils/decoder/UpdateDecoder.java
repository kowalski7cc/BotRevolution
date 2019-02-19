package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Update;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UpdateDecoder {

    public static List<Update> decodeArray(JSONArray array) {
        var list = new LinkedList<Update>();
        array.iterator().forEachRemaining(a -> list.add(decode((JSONObject) a)));
        return list;
    }

    public static Update decode(JSONObject object) {
        return new Update(object.getInt("update_id"))
                .setMessage(Optional.ofNullable(object.optJSONObject("message"))
                        .map(MessageDecoder::decode)
                        .orElse(null))
                .setEditedMessage(Optional.ofNullable(object.optJSONObject("edited_message"))
                        .map(MessageDecoder::decode)
                        .orElse(null))
                .setChannelPost(Optional.ofNullable(object.optJSONObject("channel_post"))
                        .map(MessageDecoder::decode)
                        .orElse(null))
                .setEditedChannelPost(Optional.ofNullable(object.optJSONObject("edited_channel_post"))
                        .map(MessageDecoder::decode)
                        .orElse(null))
                .setInlineQuery(Optional.ofNullable(object.optJSONObject("inline_query"))
                        .map(InlineQueryDecoder::decode)
                        .orElse(null))
                .setCallbackQuery(Optional.ofNullable(object.optJSONObject("callback_query"))
                        .map(CallbackQueryDecoder::decode)
                        .orElse(null))
                // TODO setChosenInlineResult
                .setChosenInlineResult(null)
                // TODO setShippingQuery
                .setShippingQuery(null)
                // TODO setPreCheckoutQuery
                .setPreCheckoutQuery(null);
    }
}
