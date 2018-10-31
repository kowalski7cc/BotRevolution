package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class PhotoSize extends Media {

    private Integer width;
    private Integer height;
    private Integer fileSize;

    public PhotoSize(String fileID, Integer width, Integer height) {
        super(fileID);
        this.width = Objects.requireNonNull(width);
        this.height = Objects.requireNonNull(height);
    }

    public Integer getWidth() {
        return width;
    }

    public PhotoSize setWidth(Integer width) {
        this.width = Objects.requireNonNull(width);
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public PhotoSize setHeight(Integer height) {
        this.height = Objects.requireNonNull(height);
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public PhotoSize setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoSize)) return false;
        PhotoSize photoSize = (PhotoSize) o;
        return Objects.equals(fileID, photoSize.fileID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileID);
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fileSize=" + fileSize +
                '}';
    }
}
