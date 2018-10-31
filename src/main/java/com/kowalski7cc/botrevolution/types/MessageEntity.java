package com.kowalski7cc.botrevolution.types;

import java.util.Objects;
import java.util.Optional;

public class MessageEntity {

    private MessageEntityType type;
    private Integer offset;
    private Integer length;
    private String url;
    private User user;

    public MessageEntity(MessageEntityType type, Integer offset, Integer length) {
        this.type = Objects.requireNonNull(type);
        this.offset = Objects.requireNonNull(offset);
        this.length = Objects.requireNonNull(length);
    }

    public MessageEntityType getType() {
        return type;
    }

    public MessageEntity setType(MessageEntityType type) {
        this.type = Objects.requireNonNull(type);
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public MessageEntity setOffset(Integer offset) {
        this.offset = Objects.requireNonNull(offset);
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public MessageEntity setLength(Integer length) {
        this.length = Objects.requireNonNull(length);
        return this;
    }

    public Optional<String> getUrl() {
        return Optional.ofNullable(url);
    }

    public MessageEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public Optional<User> getUser() {
        return Optional.ofNullable(user);
    }

    public MessageEntity setUser(User user) {
        this.user = user;
        return this;
    }

    public enum MessageEntityType {
        MENTION,
        HASHTAG,
        CASHTAG,
        BOT_COMMAND,
        URL,
        EMAIL,
        PHONE_NUMBER,
        BOLD,
        ITALIC,
        CODE,
        PRE,
        TEXT_LINK,
        TEXT_MENTION
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type=" + type +
                ", offset=" + offset +
                ", length=" + length +
                ", url='" + url + '\'' +
                ", user=" + user +
                '}';
    }
}
