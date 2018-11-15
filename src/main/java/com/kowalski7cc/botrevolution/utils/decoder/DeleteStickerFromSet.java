package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.actions.MethodBuilder;
import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DeleteStickerFromSet extends MethodBuilder<Boolean> {

    private String sticker;

    public DeleteStickerFromSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public DeleteStickerFromSet setSticker(String sticker) {
        this.sticker = Objects.requireNonNull(sticker);
        return this;
    }

    public DeleteStickerFromSet setSticker(Sticker sticker) {
        this.sticker = Objects.requireNonNull(sticker.getFileID());
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("sticker", Objects.requireNonNull(sticker));
        return RequestHelper.get(token, BotMethod.DELETESTICKERFROMSET, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
