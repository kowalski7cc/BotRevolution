package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.UserProfilePhotos;
import org.json.JSONObject;

public class UserProfilePhotosDecoder {

    public static UserProfilePhotos decode(JSONObject object) {
        return new UserProfilePhotos(object.getInt("total_count"),
                PhotoSizeDecoder.decodeArrayOfArray(object.getJSONArray("photos")));
    }
}
