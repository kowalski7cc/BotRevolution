package com.kowalski7cc.botrevolution.types.chat;

import java.util.Objects;
import java.util.Optional;

public abstract class Chat {

    protected Long id;
    protected ChatPhoto photo;

    public Chat(Long id) {
        this.id = Objects.requireNonNull(id);
    }

     public abstract ChatType getType();

    public Long getId() {
        return id;
    }

    public Chat setId(Long id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public Optional<ChatPhoto> getPhoto() {
        return Optional.ofNullable(photo);
    }

    public Chat setPhoto(ChatPhoto photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                '}';
    }
}
