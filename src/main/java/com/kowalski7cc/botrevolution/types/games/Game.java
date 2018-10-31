package com.kowalski7cc.botrevolution.types.games;

import com.kowalski7cc.botrevolution.types.MessageEntity;
import com.kowalski7cc.botrevolution.types.media.Animation;
import com.kowalski7cc.botrevolution.types.media.PhotoSize;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Game {

    private String title;
    private String description;
    private List<PhotoSize> photo;
    private String text;
    private List<MessageEntity> textEntities;
    private Animation animation;

    public Game(String title, String description, List<PhotoSize> photo) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.photo = Objects.requireNonNull(photo);
    }

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Game setDescription(String description) {
        this.description = Objects.requireNonNull(description);
        return this;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Game setPhoto(List<PhotoSize> photo) {
        this.photo = Objects.requireNonNull(photo);
        return this;
    }

    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    public Game setText(String text) {
        this.text = text;
        return this;
    }

    public Optional<List<MessageEntity>> getTextEntities() {
        return Optional.ofNullable(textEntities);
    }

    public Game setTextEntities(List<MessageEntity> textEntities) {
        this.textEntities = textEntities;
        return this;
    }

    public Optional<Animation> getAnimation() {
        return Optional.ofNullable(animation);
    }

    public Game setAnimation(Animation animation) {
        this.animation = animation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return title.equals(game.title) &&
                description.equals(game.description) &&
                photo.equals(game.photo) &&
                Objects.equals(text, game.text) &&
                Objects.equals(textEntities, game.textEntities) &&
                Objects.equals(animation, game.animation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, photo, text, textEntities, animation);
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", text='" + text + '\'' +
                ", textEntities=" + textEntities +
                ", animation=" + animation +
                '}';
    }
}
