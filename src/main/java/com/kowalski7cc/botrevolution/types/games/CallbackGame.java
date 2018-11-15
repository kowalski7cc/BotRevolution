package com.kowalski7cc.botrevolution.types.games;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import org.json.JSONObject;

public class CallbackGame implements JSONSerializable {
    @Override
    public JSONObject serializeJSON() {
        return new JSONObject();
    }
}
