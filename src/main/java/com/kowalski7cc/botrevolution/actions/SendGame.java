package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.types.chat.Chat;
import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SendGame extends MethodBuilder<Message> {

    private Long chatID;
    private String gameShortName;
    private Boolean disableNotification;
    private Integer replyToMessageID;
    private ReplyMarkup replyMarkup;

    public SendGame(String token, Integer timeout) {
        super(token, timeout);
    }

    public SendGame setChatID(Long chatID) {
        this.chatID = Objects.requireNonNull(chatID);
        return this;
    }

    public SendGame setChatID(Chat chat) {
        this.chatID = Objects.requireNonNull(chat.getId());
        return this;
    }

    public SendGame setGameShortName(String gameShortName) {
        this.gameShortName = Objects.requireNonNull(gameShortName);
        return this;
    }

    public SendGame setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public SendGame setReplyToMessageID(Integer replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
        return this;
    }

    public SendGame setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chat_id", Objects.requireNonNull(chatID.toString()));
        parameters.put("game_short_name", Objects.requireNonNull(gameShortName));
        if (disableNotification != null)
            parameters.put("disable_notification", disableNotification.toString());
        if (replyToMessageID != null)
            parameters.put("reply_to_message_id", replyToMessageID.toString());
        if (replyMarkup != null)
            parameters.put("reply_markup", replyMarkup.serializeJSON().toString());
        return RequestHelper.get(token, BotMethod.SENDGAME, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
