package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.stickers.MaskPosition;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CreateNewStickerSet extends SendMedia {

    private Integer userID;
    private String name;
    private String title;
    private Object pngSticker;
    private String emojis;
    private Boolean containsMasks;
    private MaskPosition maskPosition;

    public CreateNewStickerSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public CreateNewStickerSet setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public CreateNewStickerSet setName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    public CreateNewStickerSet setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public CreateNewStickerSet setPngSticker(Object pngSticker) {
        this.pngSticker = Objects.requireNonNull(pngSticker);
        return this;
    }

    public CreateNewStickerSet setEmojis(String emojis) {
        this.emojis = Objects.requireNonNull(emojis);
        return this;
    }

    public CreateNewStickerSet setContainsMasks(Boolean containsMasks) {
        this.containsMasks = containsMasks;
        return this;
    }

    public CreateNewStickerSet setMaskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("emojis", Objects.requireNonNull(emojis));
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        parameters.put("name", Objects.requireNonNull(name));
        parameters.put("title", Objects.requireNonNull(title));
        Optional.ofNullable(containsMasks).ifPresent(aBoolean -> parameters.put("contains_masks", aBoolean.toString()));
        Optional.ofNullable(maskPosition).ifPresent(maskPosition1 -> parameters.put("mask_position", maskPosition1.serializeJSON()
                .toString()));
        return sendMedia(pngSticker, parameters, BotMethod.CREATENEWSTICKERSET, "png_sticker");
    }
}
