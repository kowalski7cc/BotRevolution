package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.chat.ChatMember;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ChatMemberDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.*;

public class GetChatAdministrators extends MethodBuilder<List<ChatMember>> {

    private String chatID;

    public GetChatAdministrators(String token, Integer timeout) {
        super(token, timeout);
    }

    public GetChatAdministrators setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public GetChatAdministrators setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public GetChatAdministrators setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    @Override
    public Optional<List<ChatMember>> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        return RequestHelper.get(token, BotMethod.GETCHATADMINISTRATORS, parameters, timeout)
                .map(object -> ChatMemberDecoder.decodeArray(ResponseDecoder.decodeArray(object)));
    }
}
