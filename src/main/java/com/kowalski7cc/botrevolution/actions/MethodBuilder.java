package com.kowalski7cc.botrevolution.actions;

import java.util.Objects;
import java.util.Optional;

public abstract class MethodBuilder<T> {

    protected String token;
    protected Integer timeout;

    public MethodBuilder(String token, Integer timeout) {
        this.token = Objects.requireNonNull(token);
        this.timeout = Objects.requireNonNull(timeout);
    }

    public abstract Optional<T> send();
}
