package com.kowalski7cc.botrevolution.types.media;

import java.util.Optional;

public class FileAttachment extends Media {

    private Integer fileSize;
    private String filePath;

    public FileAttachment(String fileID) {
        super(fileID);
    }

    public Optional<Integer> getFileSize() {
        return Optional.ofNullable(fileSize);
    }

    public FileAttachment setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public Optional<String> getFilePath() {
        return Optional.ofNullable(filePath);
    }

    public FileAttachment setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                ", fileID='" + fileID + '\'' +
                '}';
    }
}
