package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UnbanChatMember extends MethodBuilder<Boolean> {

    private String chatID;
    private Integer userID;

    public UnbanChatMember(String token, Integer timeout) {
        super(token, timeout);
    }

    public UnbanChatMember setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public UnbanChatMember setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public UnbanChatMember setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public UnbanChatMember setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        return RequestHelper.get(token, BotMethod.UNBANCHATMEMBER, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
