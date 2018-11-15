package com.kowalski7cc.botrevolution.actions;

import com.kowalski7cc.botrevolution.types.games.GameHighScore;
import com.kowalski7cc.botrevolution.utils.BotMethod;
import com.kowalski7cc.botrevolution.utils.RequestHelper;
import com.kowalski7cc.botrevolution.utils.decoder.GameHighScoreDecoder;
import com.kowalski7cc.botrevolution.utils.decoder.ResponseDecoder;

import java.util.*;

public class GetGameHighScores extends MethodBuilder<List<GameHighScore>> {

    private Integer userID;
    private Integer chatID;
    private Integer messageID;
    private String inlineMessageID;

    public GetGameHighScores(String token, Integer timeout) {
        super(token, timeout);
    }

    public GetGameHighScores setUserID(Integer userID) {
        this.userID = Objects.requireNonNull(userID);
        return this;
    }

    public GetGameHighScores setChatID(Integer chatID) {
        this.chatID = chatID;
        return this;
    }

    public GetGameHighScores setMessageID(Integer messageID) {
        this.messageID = messageID;
        return this;
    }

    public GetGameHighScores setInlineMessageID(String inlineMessageID) {
        this.inlineMessageID = inlineMessageID;
        return this;
    }

    @Override
    public Optional<List<GameHighScore>> send() {
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
        return RequestHelper.get(token, BotMethod.SETGAMESCORE, parameters, timeout)
                .map(object -> GameHighScoreDecoder.decodeArray(ResponseDecoder.decodeArray(object)));
    }
}
