package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AnswerPreCheckoutQuery extends MethodBuilder<Boolean> {

    private String preCheckoutQueryId;
    private Boolean ok;
    private String errorMessage;

    public AnswerPreCheckoutQuery(String token, Integer timeout) {
        super(token, timeout);
    }

    public AnswerPreCheckoutQuery setPreCheckoutQueryId(String preCheckoutQueryId) {
        this.preCheckoutQueryId = Objects.requireNonNull(preCheckoutQueryId);
        return this;
    }

    public AnswerPreCheckoutQuery setOk(Boolean ok) {
        this.ok = Objects.requireNonNull(ok);
        return this;
    }

    public AnswerPreCheckoutQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("pre_checkout_query_id", Objects.requireNonNull(preCheckoutQueryId));
        parameters.put("ok", Objects.requireNonNull(ok.toString()));
        if (!ok)
            parameters.put("error_message", Objects.requireNonNull(errorMessage));
        return RequestHelper.get(token, BotMethod.SENDMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
