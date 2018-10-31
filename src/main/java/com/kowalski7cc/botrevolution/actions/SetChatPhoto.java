package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import org.apache.commons.lang3.NotImplementedException;

import java.io.File;
import java.util.Optional;

public class SetChatPhoto extends MethodBuilder<Boolean> {

    private String chatID;
    private File photo;

    public SetChatPhoto(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetChatPhoto setChatID(String chatID) {
        this.chatID = chatID;
        return this;
    }

    public SetChatPhoto setChatID(Chat chat) {
        this.chatID = chat.getId().toString();
        return this;
    }

    public SetChatPhoto setChatID(Long chatID) {
        this.chatID = chatID.toString();
        return this;
    }

    public SetChatPhoto setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        throw new NotImplementedException("");
    }
}
