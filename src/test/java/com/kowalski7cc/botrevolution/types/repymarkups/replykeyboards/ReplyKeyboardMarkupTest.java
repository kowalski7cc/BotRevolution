package com.kowalski7cc.botrevolution.types.repymarkups.replykeyboards;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class ReplyKeyboardMarkupTest {

    @Test
    public void serializeJSON() {

        assertEquals(new ReplyKeyboardMarkup(Collections.singletonList(
                Collections.singletonList(new KeyboardButton("Ciao"))))
                .setResizeKeyboard(true)
                .setOneTimeKeyboard(true)
                .setSelective(true)
                .serializeJSON()
                .toString(), "{\"keyboard\":[[{\"text\":\"Ciao\"}]],\"resize_keyboard\":true,\"one_time_keyboard\":true,\"selective\":true}");
    }
}