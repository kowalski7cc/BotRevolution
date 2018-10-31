package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.Venue;
import org.json.JSONObject;

public class VenueDecoder {

    public static Venue decode(JSONObject object) {
        return new Venue(LocationDecoder.decode(object.getJSONObject("location")),
                object.optString("title"),
                object.optString("address"))
                .setFoursquareID(object.optString("foursquare_id"))
                .setFoursquareType(object.optString("foursquare_type"));
    }

}
