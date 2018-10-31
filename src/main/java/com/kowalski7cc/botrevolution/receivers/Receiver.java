package com.kowalski7cc.botrevolution.receivers;

import com.kowalski7cc.botrevolution.types.Update;

import java.util.Objects;
import java.util.Queue;

public abstract class Receiver {

    protected String token;

    public Receiver(String token) {
        this.token = Objects.requireNonNull(token);
    }

    public abstract Queue<Update> getUpdates();

}