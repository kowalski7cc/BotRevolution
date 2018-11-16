package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AnswerCallbackQuery extends MethodBuilder<Boolean> {

    private String callbackQueryID;
    private String text;
    private Boolean showAlert;
    private String url;
    private Integer cacheTime;

    public AnswerCallbackQuery(String token, Integer timeout) {
        super(token, timeout);
    }

    public AnswerCallbackQuery setCallbackQueryID(String callbackQueryID) {
        this.callbackQueryID = Objects.requireNonNull(callbackQueryID);
        return this;
    }

    public AnswerCallbackQuery setText(String text) {
        this.text = text;
        return this;
    }

    public AnswerCallbackQuery setShowAlert(Boolean showAlert) {
        this.showAlert = showAlert;
        return this;
    }

    public AnswerCallbackQuery setUrl(String url) {
        this.url = url;
        return this;
    }

    public AnswerCallbackQuery setCacheTime(Integer cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("callback_query_id", Objects.requireNonNull(callbackQueryID));
        if (text != null) {
            parameters.put("text", text);
        }
        if (showAlert != null) {
            parameters.put("show_alert", showAlert.toString());
        }
        if (url != null) {
            parameters.put("url", url);
        }
        if (cacheTime != null) {
            parameters.put("cache_time", cacheTime.toString());
        }
        return RequestHelper.get(token, BotMethod.SENDMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
