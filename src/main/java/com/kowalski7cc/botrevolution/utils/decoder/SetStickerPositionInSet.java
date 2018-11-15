package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.actions.MethodBuilder;
import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SetStickerPositionInSet extends MethodBuilder<Boolean> {

    private String sticker;
    private Integer position;

    public SetStickerPositionInSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetStickerPositionInSet setSticker(String sticker) {
        this.sticker = Objects.requireNonNull(sticker);
        return this;
    }

    public SetStickerPositionInSet setSticker(Sticker sticker) {
        this.sticker = sticker.getFileID();
        return this;
    }

    public SetStickerPositionInSet setPosition(Integer position) {
        this.position = Objects.requireNonNull(position);
        if (position < 0) throw new IllegalArgumentException("position must be >0");
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("sticker", Objects.requireNonNull(sticker));
        parameters.put("position", Objects.requireNonNull(position.toString()));
        return RequestHelper.get(token, BotMethod.SETSTICKERPOSITIONINSET, parameters, timeout)
                .map(object -> ResponseDecoder.decodeBoolean(object));
    }
}
