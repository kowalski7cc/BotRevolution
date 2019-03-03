package com.kowalski7cc.botrevolution.types;

import com.kowalski7cc.botrevolution.types.chat.PrivateChat;

import java.util.Objects;
import java.util.Optional;

public class User {

    private Integer id;
    private Boolean isBot;
    private String firstName;
    private String lastName;
    private String username;
    private String languageCode;

    public User(Integer id, Boolean isBot, String firstName) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(isBot);
        Objects.requireNonNull(firstName);
        this.id = id;
        this.isBot = isBot;
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public Boolean getBot() {
        return isBot;
    }

    public User setBot(Boolean bot) {
        isBot = Objects.requireNonNull(bot);
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
        return this;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Optional<String> getLanguageCode() {
        return Optional.ofNullable(languageCode);
    }

    public User setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    public PrivateChat toChat() {
        return new PrivateChat(id.longValue(), firstName)
                .setLastName(lastName)
                .setUsername(username);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isBot=" + isBot +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", username=" + username +
                ", languageCode=" + languageCode +
                '}';
    }
}
