package com.kowalski7cc.botrevolution.types.inlinemode;

import java.util.Objects;

public abstract class InlineQueryResult {

    private String id;

    public InlineQueryResult(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public String getId() {
        return id;
    }

    public abstract InlineQueryType type();
}
