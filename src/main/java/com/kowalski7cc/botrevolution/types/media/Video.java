package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class Video extends Media {
    private Integer width;
    private Integer height;
    private Integer duration;
    private PhotoSize thumb;
    private String mimeType;
    private Integer fileSize;

    public Video(String fileID, Integer width, Integer height, Integer duration) {
        super(fileID);
        this.width = Objects.requireNonNull(width);
        this.height = Objects.requireNonNull(height);
        this.duration = Objects.requireNonNull(duration);
    }

    public Integer getWidth() {
        return width;
    }

    public Video setWidth(Integer width) {
        this.width = Objects.requireNonNull(width);
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Video setHeight(Integer height) {
        this.height = Objects.requireNonNull(height);
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public Video setDuration(Integer duration) {
        this.duration = Objects.requireNonNull(duration);
        return this;
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public Video setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<String> getMimeType() {
        return Optional.ofNullable(mimeType);
    }

    public Video setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Video setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;
        Video video = (Video) o;
        return fileID.equals(video.fileID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileID);
    }

    @Override
    public String toString() {
        return "Video{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
