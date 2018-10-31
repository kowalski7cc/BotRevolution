package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class Animation extends Media {

    private Integer width;
    private Integer height;
    private Integer duration;
    private PhotoSize thumb;
    private String fileName;
    private String mimeType;
    private Integer fileSize;

    public Animation(String fileID, Integer width, Integer height, Integer duration) {
        super(fileID);
        this.width = Objects.requireNonNull(width);
        this.height = Objects.requireNonNull(height);
        this.duration = Objects.requireNonNull(duration);
    }

    public Integer getWidth() {
        return width;
    }

    public Animation setWidth(Integer width) {
        this.width = Objects.requireNonNull(width);
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Animation setHeight(Integer height) {
        this.height = Objects.requireNonNull(height);
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public Animation setDuration(Integer duration) {
        this.duration = Objects.requireNonNull(duration);
        return this;
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public Animation setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<String> getFileName() {
        return Optional.ofNullable(fileName);
    }

    public Animation setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Optional<String> getMimeType() {
        return Optional.ofNullable(mimeType);
    }

    public Animation setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Animation setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileID='" + fileID + '\'' +
                '}';
    }
}
