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

public class RestrictChatMember extends MethodBuilder<Boolean> {

    private String chatID;
    private Integer userID;
    private Integer untilDate;
    private Boolean canSendMessages;
    private Boolean canSendMediaMessages;
    private Boolean canSendOtherMessages;
    private Boolean canAddWebPagePreviews;

    public RestrictChatMember(String token, Integer timeout) {
        super(token, timeout);
    }

    public RestrictChatMember setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public RestrictChatMember setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public RestrictChatMember setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public RestrictChatMember setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public RestrictChatMember setUserID(User user) {
        this.userID = user.getId();
        return this;
    }

    public RestrictChatMember setUntilDate(Integer untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public RestrictChatMember setCanSendMessages(Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
        return this;
    }

    public RestrictChatMember setCanSendMediaMessages(Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
        return this;
    }

    public RestrictChatMember setCanSendOtherMessages(Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
        return this;
    }

    public RestrictChatMember setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        if (untilDate != null) {
            parameters.put("until_date", untilDate.toString());
        }
        if (canSendMessages != null) {
            parameters.put("can_send_messages", canSendMessages.toString());
        }
        if (canSendMessages != null) {
            parameters.put("can_send_media_messages", canSendMediaMessages.toString());
        }
        if (canSendMessages != null) {
            parameters.put("can_send_other_messages", canSendOtherMessages.toString());
        }
        if (canSendMessages != null) {
            parameters.put("can_add_web_page_previews", canAddWebPagePreviews.toString());
        }
        return RequestHelper.get(token, BotMethod.RESTRICTCHATMEMBER, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
