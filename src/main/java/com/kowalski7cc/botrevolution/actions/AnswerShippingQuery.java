package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.payments.ShippingOption;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import org.json.JSONArray;

import java.util.*;

public class AnswerShippingQuery extends MethodBuilder<Boolean> {

    private String shippingQueryId;
    private Boolean ok;
    private List<ShippingOption> shippingOptions;
    private String errorMessage;

    public AnswerShippingQuery(String token, Integer timeout) {
        super(token, timeout);
    }

    public AnswerShippingQuery setShippingQueryId(String shippingQueryId) {
        this.shippingQueryId = Objects.requireNonNull(shippingQueryId);
        return this;
    }

    public AnswerShippingQuery setOk(Boolean ok) {
        this.ok = Objects.requireNonNull(ok);
        return this;
    }

    public AnswerShippingQuery setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
        return this;
    }

    public AnswerShippingQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("shipping_query_id", Objects.requireNonNull(shippingQueryId));
        parameters.put("ok", Objects.requireNonNull(ok.toString()));
        if(ok) {
            parameters.put("shipping_options", new JSONArray(shippingOptions.stream()
                    .map(ShippingOption::serializeJSON))
                    .toString());
        } else {
            parameters.put("error_message", Objects.requireNonNull(errorMessage));
        }
        return RequestHelper.get(token, BotMethod.SENDMESSAGE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
