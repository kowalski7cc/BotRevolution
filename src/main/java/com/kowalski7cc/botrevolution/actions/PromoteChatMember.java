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

public class PromoteChatMember extends MethodBuilder<Boolean> {

    private String chatID;
    private Integer userID;
    private Boolean canChangeInfo;
    private Boolean canPostMessages;
    private Boolean canEditMessages;
    private Boolean canDeleteMessages;
    private Boolean canInviteUsers;
    private Boolean canRestrictMembers;
    private Boolean canPinMessages;
    private Boolean canPromoteMembers;

    public PromoteChatMember(String token, Integer timeout) {
        super(token, timeout);
    }

    public PromoteChatMember setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public PromoteChatMember setChatID(Chat chat) {
        this.chatID = chatID;
        return this;
    }

    public PromoteChatMember setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public PromoteChatMember setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public PromoteChatMember setUserID(User user) {
        this.userID = user.getId();
        return this;
    }

    public PromoteChatMember setCanChangeInfo(Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return this;
    }

    public PromoteChatMember setCanPostMessages(Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return this;
    }

    public PromoteChatMember setCanEditMessages(Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return this;
    }

    public PromoteChatMember setCanDeleteMessages(Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return this;
    }

    public PromoteChatMember setCanInviteUsers(Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return this;
    }

    public PromoteChatMember setCanRestrictMembers(Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return this;
    }

    public PromoteChatMember setCanPinMessages(Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return this;
    }

    public PromoteChatMember setCanPromoteMembers(Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        if (canChangeInfo != null) {
            parameters.put("can_change_info", canChangeInfo.toString());
        }
        if (canPostMessages != null) {
            parameters.put("can_post_messages", canPostMessages.toString());
        }
        if (canEditMessages != null) {
            parameters.put("can_edit_messages", canEditMessages.toString());
        }
        if (canDeleteMessages != null) {
            parameters.put("can_delete_messages", canDeleteMessages.toString());
        }
        if (canInviteUsers != null) {
            parameters.put("can_invite_users", canInviteUsers.toString());
        }
        if (canRestrictMembers != null) {
            parameters.put("can_restrict_members", canRestrictMembers.toString());
        }
        if (canPinMessages != null) {
            parameters.put("can_pin_messages", canPinMessages.toString());
        }
        if (canPromoteMembers != null) {
            parameters.put("can_promote_members", canPromoteMembers.toString());
        }
        return RequestHelper.get(token, BotMethod.PROMOTECHATMEMBER, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
