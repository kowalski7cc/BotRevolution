package com.kowalski7cc.botrevolution.types.media;

import java.util.Objects;
import java.util.Optional;

public class Document extends Media {

    private PhotoSize thumb;
    private String mimeType;
    private String fileName;
    private Integer fileSize;

    public Document(String fileID) {
        super(fileID);
    }

    public Optional<PhotoSize> getThumb() {
        return Optional.ofNullable(thumb);
    }

    public Document setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public Optional<String> getMimeType() {
        return Optional.ofNullable(mimeType);
    }

    public Document setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Optional<String> getFileName() {
        return Optional.ofNullable(fileName);
    }

    public Document setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public Document setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return fileID.equals(document.fileID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileID);
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileID='" + fileID + '\'' +
                ", thumb=" + thumb +
                ", mimeType='" + mimeType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
