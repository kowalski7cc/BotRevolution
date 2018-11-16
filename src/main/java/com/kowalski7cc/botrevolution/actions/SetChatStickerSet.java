package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SetChatStickerSet extends MethodBuilder<Boolean> {

    private String chatID;
    private String stickerSetName;

    public SetChatStickerSet(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetChatStickerSet setChatID(String chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SetChatStickerSet setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId().toString());
        return this;
    }

    public SetChatStickerSet setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID.toString());
        return this;
    }

    public SetChatStickerSet setStickerSetName(String stickerSetName) {
        this.stickerSetName = Objects.requireNonNull(stickerSetName);
        return this;
    }

    @Override
    public Optional<Boolean> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID));
        parameters.put("sticker_set_name", Objects.requireNonNull(stickerSetName));
        return RequestHelper.get(token, BotMethod.SETCHATSTICKERSET, parameters, timeout)
                .map(ResponseDecoder::decodeBoolean);
    }
}
