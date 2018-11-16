package com.kowalski7cc.botrevolution.utils.decoder;

import com.kowalski7cc.botrevolution.types.chat.ChannelChat;
import com.kowalski7cc.botrevolution.types.chat.GroupChat;
import com.kowalski7cc.botrevolution.types.chat.PrivateChat;
import com.kowalski7cc.botrevolution.types.chat.SupergroupChat;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatDecoderTest {

    @Test
    public void decodePrivateChat() {
        var json = "{\"id\":1234,\"first_name\":\"Name\",\"last_name\":\"Surname\",\"username\"" +
                ":\"username\",\"type\":\"private\"}";
        var object = new JSONObject(json);
        var decoded = ChatDecoder.decodePrivateChat(object);
        var sample = new PrivateChat((long)1234, "Name")
                .setLastName("Surname")
                .setUsername("username");
        assertEquals(sample.getId(), decoded.getId());
        assertEquals(sample.getFirstName(), decoded.getFirstName());
        assertEquals(sample.getLastName(), decoded.getLastName());
        assertEquals(sample.getUsername(), decoded.getUsername());
    }

    @Test
    public void decodeGroupChat() {
        var json = "{\"id\":1234,\"title\":\"Group\",\"type\":\"group\",\"all_members_are_administrators\":false}";
        var object = new JSONObject(json);
        var decoded = ChatDecoder.decodeGroupChat(object);
        var sample = new GroupChat((long) 1234, "Group", false);
        assertEquals(sample.getId(), decoded.getId());
        assertEquals(sample.getTitle(), decoded.getTitle());
        assertEquals(sample.getAllMembersAreAdminitrators(), decoded.getAllMembersAreAdminitrators());
    }

    @Test
    public void decodeSupergroupChat() {
        var json = "{\"id\":1234,\"title\":\"Supergroup\",\"type\":\"supergroup\",\"description\":\"test\"" +
                ",\"invite_link\":\"test\",\"username\":\"username\"}";
        var object = new JSONObject(json);
        var decoded = ChatDecoder.decodeSupergroupChat(object);
        var sample = new SupergroupChat((long) 1234, "Supergroup")
                .setDescription("test")
                .setUsername("username")
                .setInviteLink("test");
        assertEquals(sample.getId(), decoded.getId());
        assertEquals(sample.getTitle(), decoded.getTitle());
        assertEquals(sample.getDescription(), decoded.getDescription());
        assertEquals(sample.getUsername(), decoded.getUsername());
        assertEquals(sample.getInviteLink(), decoded.getInviteLink());
    }

    @Test
    public void decodeChannelChat() {
        var json = "{\"id\":1234,\"title\":\"channel\",\"username\":\"mychannel\",\"type\":" +
                "\"channel\",\"description\":\"hello\",\"invite_link\":\"test\"}";
        var object = new JSONObject(json);
        var decoded = ChatDecoder.decodeChannelChat(object);
        var sample = new ChannelChat((long) 1234, "channel")
                .setDescription("hello")
                .setInviteLink("test")
                .setUsername("mychannel");
        assertEquals(sample.getId(), decoded.getId());
        assertEquals(sample.getDescription(), decoded.getDescription());
        assertEquals(sample.getInviteLink(), decoded.getInviteLink());
        assertEquals(sample.getUsername(), decoded.getUsername());
        assertEquals(sample.getTitle(), decoded.getTitle());
    }
}