package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.ChatAction;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendChatAction extends MethodBuilder<Boolean> {

    private String chatID;
    private ChatAction action;

    public SendChatAction(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendChatAction setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SendChatAction setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SendChatAction setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SendChatAction setAction(ChatAction action) {
        this.action = action;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("action", Objects.requireNonNull(action.toString().toLowerCase()));
        return RequestHelper.get(token, BotMethod.SENDCHATACTION, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
