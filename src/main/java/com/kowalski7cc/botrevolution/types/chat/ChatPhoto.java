package com.kowalski7cc.botrevolution.types.chat;

import java.util.Objects;

public class ChatPhoto {

    private String smallFileID;
    private String bigFileID;

    public ChatPhoto(String smallFileID, String bigFileID) {
        Objects.requireNonNull(smallFileID);
        Objects.requireNonNull(bigFileID);
        this.smallFileID = smallFileID;
        this.bigFileID = bigFileID;
    }

    public String getSmallFileID() {
        return smallFileID;
    }

    public ChatPhoto setSmallFileID(String smallFileID) {
        Objects.requireNonNull(smallFileID);
        this.smallFileID = smallFileID;
        return this;
    }

    public String getBigFileID() {
        return bigFileID;
    }

    public ChatPhoto setBigFileID(String bigFileID) {
        Objects.requireNonNull(bigFileID);
        this.bigFileID = bigFileID;
        return this;
    }

    @Override
    public String toString() {
        return "ChatPhoto{" +
                "smallFileID='" + smallFileID + '\'' +
                ", bigFileID='" + bigFileID + '\'' +
                '}';
    }
}
