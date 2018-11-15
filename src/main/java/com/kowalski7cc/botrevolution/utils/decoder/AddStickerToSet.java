package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.actions.SendMedia;
import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.User;
import com.kowalski7cc.botrevolution.types.stickers.MaskPosition;
import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AddStickerToSet extends SendMedia {

    private Integer userID;
    private String name;
    private Object pngSticker;
    private String emojis;
    private MaskPosition maskPosition;

    public AddStickerToSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public AddStickerToSet setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public AddStickerToSet setUserID(User user) {
        this.userID = Objects.requireNonNull(user.getId());
        return this;
    }

    public AddStickerToSet setName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    public AddStickerToSet setName(Sticker sticker) {
        this.name = Objects.requireNonNull(sticker.getSetName().get());
        return this;
    }

    public AddStickerToSet setPngSticker(File pngSticker) {
        this.pngSticker = Objects.requireNonNull(pngSticker);
        return this;
    }

    public AddStickerToSet setPngSticker(String pngSticker) {
        this.pngSticker = Objects.requireNonNull(pngSticker);
        return this;
    }

    public AddStickerToSet setEmojis(String emojis) {
        this.emojis = Objects.requireNonNull(emojis);
        return this;
    }

    public AddStickerToSet setMaskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        parameters.put("name", Objects.requireNonNull(name));
        parameters.put("emojis", Objects.requireNonNull(emojis));
        if (maskPosition != null ) {
            parameters.put("mask_position", maskPosition.serializeJSON().toString());
        }
        return sendMedia(pngSticker, parameters, BotMethod.ADDSTICKERTOSET, "png_sticker");
    }
}
