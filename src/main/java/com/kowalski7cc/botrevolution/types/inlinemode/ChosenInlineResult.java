package com.kowalski7cc.botrevolution.types.inlinemode;

import com.kowalski7cc.botrevolution.types.Location;
import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;
import java.util.Optional;

public class ChosenInlineResult {

    private String resultID;
    private User from;
    private Location location;
    private String inlineMessageID;
    private String query;

    public ChosenInlineResult(String resultID, User from, String query) {
        this.resultID = Objects.requireNonNull(resultID);
        this.from = Objects.requireNonNull(from);
        this.query = Objects.requireNonNull(query);
    }

    public String getResultID() {
        return resultID;
    }

    public ChosenInlineResult setResultID(String resultID) {
        this.resultID = Objects.requireNonNull(resultID);
        return this;
    }

    public User getFrom() {
        return from;
    }

    public ChosenInlineResult setFrom(User from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    public String getInlineMessageID() {
        return inlineMessageID;
    }

    public ChosenInlineResult setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = Objects.requireNonNull(inlineMessageID);
        return this;
    }

    public String getQuery() {
        return query;
    }

    public ChosenInlineResult setQuery(String query) {
        this.query = Objects.requireNonNull(query);
        return this;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public ChosenInlineResult setLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChosenInlineResult)) return false;
        ChosenInlineResult that = (ChosenInlineResult) o;
        return resultID.equals(that.resultID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultID);
    }

    @Override
    public String toString() {
        return "ChosenInlineResult{" +
                "resultID='" + resultID + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", inlineMessageID='" + inlineMessageID + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
