package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;

import java.util.Optional;

public class ExportChatInviteLink extends MethodBuilder<String> {

    private String chatID;

    public ExportChatInviteLink(String token, Integer timeout) {
        super(token, timeout);
    }

    public ExportChatInviteLink setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public ExportChatInviteLink setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public ExportChatInviteLink setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    @Override
    public Optional<String> send() {
        return Optional.empty();
    }
}
