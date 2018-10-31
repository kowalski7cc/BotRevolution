package com.kowalski7cc.botrevolution.utils.decoder;

import org.json.JSONObject;

public class TelegramException extends RuntimeException {

    public TelegramException() {
    }

    public TelegramException(String message) {
        super(message);
    }

    public TelegramException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelegramException(Throwable cause) {
        super(cause);
    }

    public TelegramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TelegramException(JSONObject object) {
        super("Error code: " + object.getInt("error_code") + ", " + object.getString("description"));
    }

}
