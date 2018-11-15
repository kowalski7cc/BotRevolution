package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.games.GameHighScore;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GameHighScoreDecoder {

    public static List<GameHighScore> decodeArray(JSONArray array) {
        List<GameHighScore> highScores = new LinkedList<>();
        array.forEach(o -> highScores.add(decode((JSONObject) o)));
        return highScores;
    }

    public static GameHighScore decode(JSONObject object) {
        return new GameHighScore(object.getInt("position"),
                UserDecoder.decode(object.getJSONObject("user")),
                object.getInt("score"));
    }
}
