package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Location;
import org.json.JSONObject;

public class LocationDecoder {

    public static Location decode(JSONObject object) {
        return new Location(object.getFloat("longitude"), object.getFloat("latitude"));
    }
}
