package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.WebhookInfo;
import org.json.JSONObject;
import java.util.stream.Collectors;

public class WebhookInfoDecoder {

    public static WebhookInfo decode(JSONObject object) {
        return new WebhookInfo(object.getString("url"), object.getInt("pending_update_count"))
                .setHasCustomCertificate(object.optBoolean("has_custom_certificate"))
                .setPendingUpdateCount(object.optInt("pending_update_count"))
                .setLastRrrorDate(object.optInt("last_error_date"))
                .setLastErrorMessage(object.optString("last_error_message"))
                .setMaxConnections(object.optInt("max_connections"))
                .setAllowedUpdates(object.getJSONArray("allowed_updates")
                        .toList()
                        .stream()
                        .map(o -> o.toString())
                        .collect(Collectors.toList()));
    }

}
