package com.kowalski7cc.botrevolution.types.games;

import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;

public class GameHighScore {

    private Integer position;
    private User user;
    private Integer score;

    public GameHighScore(Integer position, User user, Integer score) {
        this.position = Objects.requireNonNull(position);
        this.user = Objects.requireNonNull(user);
        this.score = Objects.requireNonNull(score);
    }

    public Integer getPosition() {
        return position;
    }

    public GameHighScore setPosition(Integer position) {
        this.position = Objects.requireNonNull(position);
        return this;
    }

    public User getUser() {
        return user;
    }

    public GameHighScore setUser(User user) {
        this.user = Objects.requireNonNull(user);
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public GameHighScore setScore(Integer score) {
        this.score = Objects.requireNonNull(score);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameHighScore)) return false;
        GameHighScore that = (GameHighScore) o;
        return position.equals(that.position) &&
                user.equals(that.user) &&
                score.equals(that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, user, score);
    }

    @Override
    public String toString() {
        return "GameHighScore{" +
                "position=" + position +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
