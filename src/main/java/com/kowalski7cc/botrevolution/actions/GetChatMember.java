package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.chat.ChatMember;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ChatMemberDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GetChatMember extends MethodBuilder<ChatMember> {

    private String chatID;

    public GetChatMember(String token, Integer timeout) {
        super(token, timeout);
    }

    public GetChatMember setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public GetChatMember setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public GetChatMember setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    @Override
    public Optional<ChatMember> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        return RequestHelper.get(token, BotMethod.GETCHATMEMBER, parameters, timeout)
                .map(object -> ChatMemberDecoder.decode(ResponseDecoder.decode(object)));
    }
}
