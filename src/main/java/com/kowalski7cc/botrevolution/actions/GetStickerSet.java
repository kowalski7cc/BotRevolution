package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.stickers.Sticker;
import com.kowalski7cc.botrevolution.types.stickers.StickerSet;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.StickerSetDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GetStickerSet extends MethodBuilder<StickerSet> {

    private String name;

    public GetStickerSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public GetStickerSet setName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    public GetStickerSet setName(Sticker sticker) {
        this.name = sticker.getSetName().get();
        return this;
    }

    @Override
    public Optional<StickerSet> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", Objects.requireNonNull(name));
        return RequestHelper.get(token, BotMethod.GETSTICKERSET, parameters, timeout)
                .map(object -> StickerSetDecoder.decode(ResponseDecoder.decode(object)));
    }
}
