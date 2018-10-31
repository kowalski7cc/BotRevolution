package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class VideoNote extends Media {

    private Integer length;
    private Integer duration;
    private PhotoSize thumb;
    private Integer fileSize;

    public VideoNote(String fileID, Integer length, Integer duration) {
        super(fileID);
        this.length = Objects.requireNonNull(length);
        this.duration = Objects.requireNonNull(duration);
    }

    public Integer getLength() {
        return length;
    }

    public VideoNote setLength(Integer length) {
        this.length = Objects.requireNonNull(length);
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public VideoNote setDuration(Integer duration) {
        this.duration = Objects.requireNonNull(duration);
        return this;
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public VideoNote setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public VideoNote setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public String toString() {
        return "VideoNote{" +
                "length=" + length +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", fileSize=" + fileSize +
                ", fileID='" + fileID + '\'' +
                '}';
    }
}
