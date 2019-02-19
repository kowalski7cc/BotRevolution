package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard.CallbackQuery;
import org.json.JSONObject;

import java.util.Optional;

public class CallbackQueryDecoder {

    public static CallbackQuery decode(JSONObject object) {
        return new CallbackQuery(object.getString("id"),
                UserDecoder.decode(object.getJSONObject("from")),
                object.getString("chat_instance"))
                .setMessage(Optional.ofNullable(object.optJSONObject("message"))
                        .map(MessageDecoder::decode)
                        .orElse(null))
                .setInlineMessageID(object.optString("inline_message_id"))
                .setGameShortName(object.optString("game_short_name"))
                .setData(object.optString("data"));
    }


}
