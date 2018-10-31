package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.MessageEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MessageEntityDecoder {

    public static List<MessageEntity> decodeArray(JSONArray array) {
        var list = new LinkedList<MessageEntity>();
        array.iterator().forEachRemaining(o -> list.add(decode((JSONObject) o)));
        return list;
    }

    public static MessageEntity decode(JSONObject object) {
        return new MessageEntity(decodeMessageEntityType(object),
                object.getInt("offset"), object.getInt("length"))
                .setUrl(object.optString("url"))
                .setUser(object.has("user")?UserDecoder.decode(object.getJSONObject("user")):null);
    }

    private static MessageEntity.MessageEntityType decodeMessageEntityType(JSONObject object) {
        switch (object.getString("type")) {
            case "mention":
                return MessageEntity.MessageEntityType.MENTION;
            case "hashtag":
                return MessageEntity.MessageEntityType.HASHTAG;
            case "cashtag":
                return MessageEntity.MessageEntityType.CASHTAG;
            case "bot_command":
                return MessageEntity.MessageEntityType.BOT_COMMAND;
            case "url":
                return MessageEntity.MessageEntityType.URL;
            case "email":
                return MessageEntity.MessageEntityType.EMAIL;
            case "phone_number":
                return MessageEntity.MessageEntityType.PHONE_NUMBER;
            case "bold":
                return MessageEntity.MessageEntityType.BOLD;
            case "italic":
                return MessageEntity.MessageEntityType.ITALIC;
            case "code":
                return MessageEntity.MessageEntityType.CODE;
            case "pre":
                return MessageEntity.MessageEntityType.PRE;
            case "text_link":
                return MessageEntity.MessageEntityType.TEXT_LINK;
            case "text_mention":
                return MessageEntity.MessageEntityType.TEXT_MENTION;
        }
        throw new UnsupportedOperationException();
    }
}
