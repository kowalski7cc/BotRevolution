package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.stickers.MaskPosition;
import org.json.JSONObject;

public class MaskPositionDecoder {

    public static MaskPosition decode(JSONObject object) {
        return new MaskPosition( getMaskPositionPoint(object.getString("point")),
                object.getFloat("x_shift"),
                object.getFloat("y_shift"),
                object.getFloat("scale"));
    }

    private static MaskPosition.MaskPositionPoint getMaskPositionPoint(String string) {
        switch (string) {
            case "forehead":
                return MaskPosition.MaskPositionPoint.FOREHEAD;
            case "eyes":
                return MaskPosition.MaskPositionPoint.EYES;
            case "mouth":
                return MaskPosition.MaskPositionPoint.MOUTH;
            case "chin":
                return MaskPosition.MaskPositionPoint.CHIN;
        }
        throw new UnsupportedOperationException();
    }
}
