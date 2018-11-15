package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.User;
import com.kowalski7cc.botrevolution.utils.BotMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UploadStickerFile extends SendMedia {

    private Integer userID;
    private File pngSticker;

    public UploadStickerFile(String token, Integer timeout) {
        super(token, timeout);
    }

    public UploadStickerFile setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public UploadStickerFile setUserID(User user) {
        this.userID = Objects.requireNonNull(user.getId());
        return this;
    }

    public UploadStickerFile setPngSticker(File pngSticker) {
        this.pngSticker = Objects.requireNonNull(pngSticker);
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        return sendMedia(pngSticker, parameters, BotMethod.UPLOADSTICKERFILE, "png_sticker");
    }
}
