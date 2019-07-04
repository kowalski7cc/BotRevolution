package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard.CallbackQuery;
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

    public AnswerCallbackQuery setCallbackQueryID(CallbackQuery callbackQuery) {
        this.callbackQueryID = Objects.requireNonNull(callbackQuery.getId());
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
        Optional.ofNullable(text).ifPresent(s -> parameters.put("text", text));
        Optional.ofNullable(showAlert).ifPresent(aBoolean -> parameters.put("show_alert", showAlert.toString()));
        Optional.ofNullable(url).ifPresent(s -> parameters.put("url", s));
        Optional.ofNullable(cacheTime).ifPresent(integer -> parameters.put("cache_time", integer.toString()));
        return RequestHelper.get(token, BotMethod.ANSWERCALLBACKQUERY, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
