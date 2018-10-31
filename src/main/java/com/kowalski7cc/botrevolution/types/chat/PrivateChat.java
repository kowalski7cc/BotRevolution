package com.kowalski7cc.botrevolution.types.chat;

import java.util.Objects;
import java.util.Optional;

public class PrivateChat extends Chat {

    private String username;
    private String firstName;
    private String lastName;

    public PrivateChat(Long id, String firstName) {
        super(id);
        this.firstName = Objects.requireNonNull(firstName);
    }

    @Override
    public ChatType getType() {
        return ChatType.PRIVATE;
    }

    public String getFirstName() {
        return firstName;
    }

    public PrivateChat setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
        return this;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public PrivateChat setUsername(String username) {
        this.username = username;
        return this;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public PrivateChat setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "PrivateChat{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", photo=" + photo +
                '}';
    }
}
