package com.kowalski7cc.botrevolution.types.stickers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StickerSet {

    private String name;
    private String title;
    private Boolean containsMask;
    private List<Sticker> stickers;

    public StickerSet(String name, String title, Boolean containsMask, List<Sticker> stickers) {
        this.name = Objects.requireNonNull(name);
        this.title = Objects.requireNonNull(title);
        this.containsMask = Objects.requireNonNull(containsMask);
        this.stickers = Objects.requireNonNull(stickers);
    }

    public StickerSet(String name, String title, List<Sticker> stickers) {
        this.name = Objects.requireNonNull(name);
        this.title = Objects.requireNonNull(title);
        this.containsMask = false;
        this.stickers = Objects.requireNonNull(stickers);
    }

    public String getName() {
        return name;
    }

    public StickerSet setName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StickerSet setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public Optional<Boolean> getContainsMask() {
        return Optional.ofNullable(containsMask);
    }

    public StickerSet setContainsMask(Boolean containsMask) {
        this.containsMask = containsMask == null?false:containsMask;
        return this;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    public StickerSet setStickers(List<Sticker> stickers) {
        this.stickers = Objects.requireNonNull(stickers);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StickerSet)) return false;
        StickerSet that = (StickerSet) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", containsMask=" + containsMask +
                ", stickers=" + stickers +
                '}';
    }
}
