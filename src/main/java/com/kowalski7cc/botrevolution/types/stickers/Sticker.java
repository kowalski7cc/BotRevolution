package com.kowalski7cc.botrevolution.types.stickers;

import com.kowalski7cc.botrevolution.types.media.PhotoSize;

import java.util.Objects;
import java.util.Optional;

public class Sticker {

    private String fileID;
    private Integer width;
    private Integer height;
    private PhotoSize thumb;
    private String emoji;
    private String setName;
    private MaskPosition maskPosition;
    private Integer fileSize;

    public Sticker(String fileID, Integer width, Integer height) {
        this.fileID = Objects.requireNonNull(fileID);
        this.width = Objects.requireNonNull(width);
        this.height = Objects.requireNonNull(height);
    }

    public String getFileID() {
        return fileID;
    }

    public Sticker setFileID(String fileID) {
        this.fileID = Objects.requireNonNull(fileID);
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Sticker setWidth(Integer width) {
        this.width = Objects.requireNonNull(width);
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Sticker setHeight(Integer height) {
        this.height = Objects.requireNonNull(height);
        return this;
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public Sticker setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<String> getEmoji() {
        return Optional.ofNullable(emoji);
    }

    public Sticker setEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }

    public Optional<String> getSetName() {
        return Optional.ofNullable(setName);
    }

    public Sticker setSetName(String setName) {
        this.setName = setName;
        return this;
    }

    public Optional<MaskPosition> getMaskPosition() {
        return Optional.ofNullable(maskPosition);
    }

    public Sticker setMaskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Sticker setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sticker)) return false;
        Sticker sticker = (Sticker) o;
        return fileID.equals(sticker.fileID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileID);
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", emoji='" + emoji + '\'' +
                ", setName='" + setName + '\'' +
                ", maskPosition=" + maskPosition +
                ", fileSize=" + fileSize +
                '}';
    }
}
