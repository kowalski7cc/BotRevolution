package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.chat.ChatPhoto;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatPhotoDecoderTest {

    @Test
    public void decode() {
        var json = "{\"small_file_id\":\"abcdef\",\"big_file_id\":\"ghilm\"}";
        var object = new JSONObject(json);
        var decoded = ChatPhotoDecoder.decode(object);
        var sample = new ChatPhoto("abcdef", "ghilm");
        assertEquals(sample.getSmallFileID(), decoded.getSmallFileID());
        assertEquals(sample.getBigFileID(), decoded.getBigFileID());
    }
}