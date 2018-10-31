package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;

public abstract class Media implements FileID {

    protected String fileID;

    public Media(String fileID) {
        this.fileID = Objects.requireNonNull(fileID);
    }

    @Override
    public String getFileID() {
        return fileID;
    }

    public Media setFileID(String fileID) {
        this.fileID = Objects.requireNonNull(fileID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return fileID.equals(media.fileID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileID);
    }

    @Override
    public String toString() {
        return "Media{" +
                "fileID='" + fileID + '\'' +
                '}';
    }
}
