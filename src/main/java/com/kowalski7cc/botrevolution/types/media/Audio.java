package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class Audio extends Media  {

    private Integer duration;
    private String performer;
    private String title;
    private String mimeType;
    private Integer fileSize;
    private PhotoSize thumb;

    public Audio(String fileID, Integer duration) {
        super(fileID);
        this.duration = Objects.requireNonNull(duration);
    }

    public Integer getDuration() {
        return duration;
    }

    public Audio setDuration(Integer duration) {
        this.duration = Objects.requireNonNull(duration);
        return this;
    }

    public Optional<String> getMimeType() {
        return Optional.ofNullable(mimeType);
    }

    public Audio setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Audio setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public Audio setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<String> getPerformer() {
        return Optional.ofNullable(performer);
    }

    public Audio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Audio setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", thumb=" + thumb +
                ", fileID='" + fileID + '\'' +
                '}';
    }
}
