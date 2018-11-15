package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.Message;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.MessageDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SetGameScore extends MethodBuilder<Message> {

    private Integer userID;
    private Integer score;
    private Boolean force;
    private Boolean disableEditMessage;
    private Integer chatID;
    private Integer messageID;
    private String inlineMessageID;

    public SetGameScore(String token, Integer timeout) {
        super(token, timeout);
    }

    public SetGameScore setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public SetGameScore setScore(Integer score) {
        this.score = Objects.requireNonNull(score);
        return this;
    }

    public SetGameScore setForce(Boolean force) {
        this.force = force;
        return this;
    }

    public SetGameScore setDisableEditMessage(Boolean disableEditMessage) {
        this.disableEditMessage = disableEditMessage;
        return this;
    }

    public SetGameScore setChatID(Integer chatID) {
        this.chatID = chatID;
        return this;
    }

    public SetGameScore setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public SetGameScore setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    @Override
    public Optional<Message> send() {
        Map<String, String> parameters = new HashMap<>();
        if (chatID != null && messageID != null) {
            parameters.put("chat_id", Objects.requireNonNull(chatID.toString()));
            parameters.put("message_id", Objects.requireNonNull(messageID.toString()));
        } else if (inlineMessageID != null) {
            parameters.put("inline_message_id", Objects.requireNonNull(inlineMessageID));
        } else {
            throw new IllegalArgumentException("You must provide chatID and messageID or inlineMessageID");
        }
        parameters.put("user_id", Objects.requireNonNull(userID.toString()));
        parameters.put("score", Objects.requireNonNull(score.toString()));
        parameters.put("force", Objects.requireNonNull(force.toString()));
        if (disableEditMessage != null)
            parameters.put("disable_edit_message", disableEditMessage.toString());
        return RequestHelper.get(token, BotMethod.SETGAMESCORE, parameters, timeout)
                .map(object -> MessageDecoder.decode(ResponseDecoder.decode(object)));
    }
}
