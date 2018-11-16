package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.User;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDecoderTest {

    @Test
    public void decode() {
        var json = "{\"id\":1234,\"is_bot\":false,\"first_name\":\"Name\"" +
                ",\"last_name\":\"Surname\",\"username\":\"username\",\"language_code\":\"en-US\"}";
        var object = new JSONObject(json);
        var decoded = UserDecoder.decode(object);
        var sample = new User(1234, false, "Name").setLastName("Surname")
                .setLanguageCode("en-US")
                .setUsername("username");
        assertEquals(sample.getId(), decoded.getId());
        assertEquals(sample.getBot(), decoded.getBot());
        assertEquals(sample.getFirstName(), decoded.getFirstName());
        assertEquals(sample.getLastName(), decoded.getLastName());
        assertEquals(sample.getLanguageCode(), decoded.getLanguageCode());
        assertEquals(sample.getUsername(), decoded.getUsername());
    }
}