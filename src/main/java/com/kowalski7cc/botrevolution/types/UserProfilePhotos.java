package com.kowalski7cc.botrevolution.types;

import com.kowalski7cc.botrevolution.types.media.PhotoSize;

import java.util.List;
import java.util.Objects;

public class UserProfilePhotos {

    private Integer totalCount;
    private List<List<PhotoSize>> photos;

    public UserProfilePhotos(Integer totalCount, List<List<PhotoSize>> photos) {
        this.totalCount = totalCount;
        this.photos = photos;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public UserProfilePhotos setTotalCount(Integer totalCount) {
        this.totalCount = Objects.requireNonNull(totalCount);
        return this;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    public UserProfilePhotos setPhotos(List<List<PhotoSize>> photos) {
        this.photos = Objects.requireNonNull(photos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfilePhotos)) return false;
        UserProfilePhotos that = (UserProfilePhotos) o;
        return photos.equals(that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photos);
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "totalCount=" + totalCount +
                ", photos=" + photos +
                '}';
    }
}
