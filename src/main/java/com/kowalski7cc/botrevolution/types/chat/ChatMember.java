package com.kowalski7cc.botrevolution.types.chat;

import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;
import java.util.Optional;

public class ChatMember {

    private User user;
    private String status;
    private Integer untilDate;
    private Boolean canBeEdited;
    private Boolean canChangeInfo;
    private Boolean canPostMessages;
    private Boolean canEditMessages;
    private Boolean canDeleteMessages;
    private Boolean canInviteUsers;
    private Boolean canRestrictMembers;
    private Boolean canPinMessages;
    private Boolean canPromoteMembers;
    private Boolean canSendMessages;
    private Boolean canSendMediaMessages;
    private Boolean canSendOtherMessages;
    private Boolean canAddWebPagePreviews;

    public ChatMember(User user, String status) {
        this.user = Objects.requireNonNull(user);
        this.status = Objects.requireNonNull(status);
    }

    public User getUser() {
        return user;
    }

    public ChatMember setUser(User user) {
        this.user = Objects.requireNonNull(user);
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ChatMember setStatus(String status) {
        this.status = Objects.requireNonNull(status);
        return this;
    }

    public Optional<Integer> getUntilDate() {
        return Optional.ofNullable(untilDate);
    }

    public ChatMember setUntilDate(Integer untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public Optional<Boolean> getCanBeEdited() {
        return Optional.ofNullable(canBeEdited);
    }

    public ChatMember setCanBeEdited(Boolean canBeEdited) {
        this.canBeEdited = canBeEdited;
        return this;
    }

    public Optional<Boolean> getCanChangeInfo() {
        return Optional.ofNullable(canChangeInfo);
    }

    public ChatMember setCanChangeInfo(Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return this;
    }

    public Optional<Boolean> getCanPostMessages() {
        return Optional.ofNullable(canPostMessages);
    }

    public ChatMember setCanPostMessages(Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return this;
    }

    public Optional<Boolean> getCanEditMessages() {
        return Optional.ofNullable(canEditMessages);
    }

    public ChatMember setCanEditMessages(Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return this;
    }

    public Optional<Boolean> getCanDeleteMessages() {
        return Optional.ofNullable(canDeleteMessages);
    }

    public ChatMember setCanDeleteMessages(Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return this;
    }

    public Optional<Boolean> getCanInviteUsers() {
        return Optional.ofNullable(canInviteUsers);
    }

    public ChatMember setCanInviteUsers(Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return this;
    }

    public Optional<Boolean> getCanRestrictMembers() {
        return Optional.ofNullable(canRestrictMembers);
    }

    public ChatMember setCanRestrictMembers(Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return this;
    }

    public Optional<Boolean> getCanPinMessages() {
        return Optional.ofNullable(canPinMessages);
    }

    public ChatMember setCanPinMessages(Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return this;
    }

    public Optional<Boolean> getCanPromoteMembers() {
        return Optional.ofNullable(canPromoteMembers);
    }

    public ChatMember setCanPromoteMembers(Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return this;
    }

    public Optional<Boolean> getCanSendMessages() {
        return Optional.ofNullable(canSendMessages);
    }

    public ChatMember setCanSendMessages(Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
        return this;
    }

    public Optional<Boolean> getCanSendMediaMessages() {
        return Optional.ofNullable(canSendMediaMessages);
    }

    public ChatMember setCanSendMediaMessages(Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
        return this;
    }

    public Optional<Boolean> getCanSendOtherMessages() {
        return Optional.ofNullable(canSendOtherMessages);
    }

    public ChatMember setCanSendOtherMessages(Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
        return this;
    }

    public Optional<Boolean> getCanAddWebPagePreviews() {
        return Optional.ofNullable(canAddWebPagePreviews);
    }

    public ChatMember setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMember that = (ChatMember) o;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + user +
                ", status='" + status + '\'' +
                ", untilDate=" + untilDate +
                ", canBeEdited=" + canBeEdited +
                ", canChangeInfo=" + canChangeInfo +
                ", canPostMessages=" + canPostMessages +
                ", canEditMessages=" + canEditMessages +
                ", canDeleteMessages=" + canDeleteMessages +
                ", canInviteUsers=" + canInviteUsers +
                ", canRestrictMembers=" + canRestrictMembers +
                ", canPinMessages=" + canPinMessages +
                ", canPromoteMembers=" + canPromoteMembers +
                ", canSendMessages=" + canSendMessages +
                ", canSendMediaMessages=" + canSendMediaMessages +
                ", canSendOtherMessages=" + canSendOtherMessages +
                ", canAddWebPagePreviews=" + canAddWebPagePreviews +
                '}';
    }
}
