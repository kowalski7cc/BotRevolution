package com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard;

import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class InlineKeyboardMarkup implements ReplyMarkup {

    private List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup(List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    public InlineKeyboardMarkup setInlineKeyboard(List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = Objects.requireNonNull(inlineKeyboard);
        return this;
    }

    @Override
    public JSONObject serializeJSON() {
        JSONObject object = new JSONObject();
        JSONArray row = new JSONArray();
        inlineKeyboard.forEach(inlineKeyboardButtons -> {
            JSONArray col = new JSONArray();
            inlineKeyboardButtons.forEach(inlineKeyboardButton -> col.put(inlineKeyboardButton.serializeJSON()));
            row.put(col);
        });
        object.put("inline_keyboard", row);
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;
        return inlineKeyboard.equals(that.inlineKeyboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inlineKeyboard);
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup{" +
                "inlineKeyboard=" + inlineKeyboard +
                '}';
    }
}
