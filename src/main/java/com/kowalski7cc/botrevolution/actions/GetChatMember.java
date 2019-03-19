package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.User;
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
    private Integer userID;

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

    public GetChatMember setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public GetChatMember setUserID(User user) {
        this.userID = Objects.requireNonNull(user.getId());
        return this;
    }

    public GetChatMember setFromMessage(Message message) {
        this.userID = message.getFrom().get().getId();
        this.chatID = message.getChat().getId().toString();
        return this;
    }

    @Override
    public Optional<ChatMember> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("user_id", Objects.requireNonNull(userID).toString());
        return RequestHelper.get(token, BotMethod.GETCHATMEMBER, parameters, timeout)
                .map(object -> ChatMemberDecoder.decode(ResponseDecoder.decode(object)));
    }
}
