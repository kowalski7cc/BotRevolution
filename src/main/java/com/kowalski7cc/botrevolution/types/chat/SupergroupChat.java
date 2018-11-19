package com.kowalski7cc.botrevolution.types.chat;

import com.kowalski7cc.botrevolution.types.Message;

import java.util.Objects;
import java.util.Optional;

public class SupergroupChat extends Chat {

    private String title;
    private String username;
    private String description;
    private String inviteLink;
    private Message pinnedMessage;
    private String stickerSetName;
    private Boolean canSetStickerSet;

    public SupergroupChat(Long id, String title) {
        super(id);
        this.title = Objects.requireNonNull(title);
    }

    @Override
    public ChatType getType() {
        return ChatType.SUPERGROUP;
    }

    @Override
    public ChatType getChatType() {
        return ChatType.SUPERGROUP;
    }

    @Override
    public Optional<SupergroupChat> getSupergroupChat() {
        return Optional.of(this);
    }

    public String getTitle() {
        return title;
    }

    public SupergroupChat setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public SupergroupChat setUsername(String username) {
        this.username = username;
        return this;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public SupergroupChat setDescription(String description) {
        this.description = description;
        return this;
    }



    public Optional<String> getInviteLink() {
        return Optional.ofNullable(inviteLink);
    }

    public SupergroupChat setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
        return this;
    }

    public Optional<Message> getPinnedMessage() {
        return Optional.ofNullable(pinnedMessage);
    }

    public SupergroupChat setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
        return this;
    }

    public Optional<String> getStickerSetName() {
        return Optional.ofNullable(stickerSetName);
    }

    public SupergroupChat setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
        return this;
    }

    public Optional<Boolean> getCanSetStickerSet() {
        return Optional.ofNullable(canSetStickerSet);
    }

    public SupergroupChat setCanSetStickerSet(Boolean canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
        return this;
    }

    @Override
    public String toString() {
        return "SupergroupChat{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", inviteLink='" + inviteLink + '\'' +
                ", pinnedMessage=" + pinnedMessage +
                ", stickerSetName='" + stickerSetName + '\'' +
                ", canSetStickerSet=" + canSetStickerSet +
                ", id=" + id +
                ", photo=" + photo +
                '}';
    }
}
