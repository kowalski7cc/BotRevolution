package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.inlinemode.InlineQuery;
import org.json.JSONObject;

import java.util.Optional;

public class InlineQueryDecoder {

    public static InlineQuery decode(JSONObject object) {
        return new InlineQuery(object.getString("id"),
                UserDecoder.decode(object.getJSONObject("from")),
                object.getString("query"),
                object.getString("offset"))
                .setLocation(Optional.ofNullable(object.optJSONObject("location"))
                        .map(LocationDecoder::decode)
                        .orElse(null));
    }

}
