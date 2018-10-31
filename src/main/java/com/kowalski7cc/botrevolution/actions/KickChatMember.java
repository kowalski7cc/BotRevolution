package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.User;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class KickChatMember extends MethodBuilder<Boolean> {

    private String chatID;
    private Integer userID;
    private Integer untilDate;

    public KickChatMember setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public KickChatMember setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public KickChatMember setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public KickChatMember setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public KickChatMember setUserID(User user) {
        this.userID = user.getId();
        return this;
    }

    public KickChatMember setUntilDate(Integer untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public KickChatMember(String token, Integer timeout) {
        super(token, timeout);
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        if (untilDate != null) {
            parameters.put("until_date", untilDate.toString());
        }
        return RequestHelper.get(token, BotMethod.KICKCHATMEMBER, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
