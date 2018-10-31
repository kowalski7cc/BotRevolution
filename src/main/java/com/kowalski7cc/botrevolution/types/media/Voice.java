package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class Voice extends Media {

    private Integer duration;
    private String mimeType;
    private Integer fileSize;

    public Voice(String fileID, Integer duration) {
        super(fileID);
        this.duration = Objects.requireNonNull(duration);
    }

    public Integer getDuration() {
        return duration;
    }

    public Voice setDuration(Integer duration) {
        this.duration = Objects.requireNonNull(duration);
        return this;
    }

    public Optional<String> getMimeType() {
        return Optional.ofNullable(mimeType);
    }

    public Voice setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Voice setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", fileID='" + fileID + '\'' +
                '}';
    }
}
