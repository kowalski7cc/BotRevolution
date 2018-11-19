package com.kowalski7cc.botrevolution.types.chat;

import com.kowalski7cc.botrevolution.types.Message;

import java.util.Objects;
import java.util.Optional;

public class ChannelChat extends Chat {

    private String title;
    private String username;
    private String description;
    private String inviteLink;
    private Message pinnedMessage;

    public ChannelChat(Long id, String title) {
        super(id);
        this.title = Objects.requireNonNull(title);
    }

    @Override
    public ChatType getType() {
        return ChatType.CHANNEL;
    }

    @Override
    public ChatType getChatType() {
        return ChatType.CHANNEL;
    }

    @Override
    public Optional<ChannelChat> getChannelChat() {
        return Optional.of(this);
    }

    public String getTitle() {
        return title;
    }

    public ChannelChat setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public ChannelChat setUsername(String username) {
        this.username = username;
        return this;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public ChannelChat setDescription(String description) {
        this.description = description;
        return this;
    }

    public Optional<String> getInviteLink() {
        return Optional.ofNullable(inviteLink);
    }

    public ChannelChat setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
        return this;
    }

    public Optional<Message> getPinnedMessage() {
        return Optional.ofNullable(pinnedMessage);
    }

    public ChannelChat setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
        return this;
    }

    @Override
    public String toString() {
        return "ChannelChat{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", inviteLink='" + inviteLink + '\'' +
                ", pinnedMessage=" + pinnedMessage +
                ", id=" + id +
                ", photo=" + photo +
                '}';
    }
}
