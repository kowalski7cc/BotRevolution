package com.kowalski7cc.botrevolution.types.inlinemode;

import com.kowalski7cc.botrevolution.types.Location;
import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;
import java.util.Optional;

public class InlineQuery {

    private String id;
    private User from;
    private Location location;
    private String query;
    private String offset;

    public InlineQuery(String id, User from, String query, String offset) {
        this.id = Objects.requireNonNull(id);
        this.from = Objects.requireNonNull(from);
        this.query = Objects.requireNonNull(query);
        this.offset = Objects.requireNonNull(offset);
    }

    public String getId() {
        return id;
    }

    public InlineQuery setId(String id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public User getFrom() {
        return from;
    }

    public InlineQuery setFrom(User from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    public String getQuery() {
        return query;
    }

    public InlineQuery setQuery(String query) {
        this.query = Objects.requireNonNull(query);
        return this;
    }

    public String getOffset() {
        return offset;
    }

    public InlineQuery setOffset(String offset) {
        this.offset = Objects.requireNonNull(offset);
        return this;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public InlineQuery setLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InlineQuery)) return false;
        InlineQuery that = (InlineQuery) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "InlineQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", query='" + query + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
