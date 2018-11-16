package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SetChatTitle extends MethodBuilder<Boolean> {


    private String chatID;
    private String title;

    public SetChatTitle(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetChatTitle setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SetChatTitle setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("title", Objects.requireNonNull(title));
        return RequestHelper.get(token, BotMethod.SETCHATTITLE, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
