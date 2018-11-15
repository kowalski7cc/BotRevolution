package com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;
import java.util.Optional;

public class CallbackQuery {

    private Integer id;
    private User from;
    private Message message;
    private String inlineMessageID;
    private String chatInstance;
    private String data;
    private String gameShortName;

    public CallbackQuery(Integer id, User from, String chatInstance) {
        this.id = id;
        this.from = from;
        this.chatInstance = chatInstance;
    }

    public Integer getId() {
        return id;
    }

    public CallbackQuery setId(Integer id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public User getFrom() {
        return from;
    }

    public CallbackQuery setFrom(User from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    public String getChatInstance() {
        return chatInstance;
    }

    public CallbackQuery setChatInstance(String chatInstance) {
        this.chatInstance = Objects.requireNonNull(chatInstance);
        return this;
    }

    public Optional<Message> getMessage() {
        return Optional.ofNullable(message);
    }

    public CallbackQuery setMessage(Message message) {
        this.message = message;
        return this;
    }

    public Optional<String> getInlineMessageID() {
        return Optional.ofNullable(inlineMessageID);
    }

    public CallbackQuery setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    public Optional<String> getData() {
        return Optional.ofNullable(data);
    }

    public CallbackQuery setData(String data) {
        this.data = data;
        return this;
    }

    public Optional<String> getGameShortName() {
        return Optional.ofNullable(gameShortName);
    }

    public CallbackQuery setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallbackQuery)) return false;
        CallbackQuery that = (CallbackQuery) o;
        return id.equals(that.id) &&
                from.equals(that.from) &&
                chatInstance.equals(that.chatInstance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, chatInstance);
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id=" + id +
                ", from=" + from +
                ", message=" + message +
                ", inlineMessageID='" + inlineMessageID + '\'' +
                ", chatInstance='" + chatInstance + '\'' +
                ", data='" + data + '\'' +
                ", gameShortName='" + gameShortName + '\'' +
                '}';
    }
}
