package com.kowalski7cc.botrevolution.types.repymarkups.replykeyboards;

import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReplyKeyboardMarkup implements ReplyMarkup {

    private List<List<KeyboardButton>> keyboard;
    private Boolean resizeKeyboard;
    private Boolean oneTimeKeyboard;
    private Boolean selective;

    public ReplyKeyboardMarkup(List<List<KeyboardButton>> keyboard) {
        this.keyboard = Objects.requireNonNull(keyboard);
    }

    public ReplyKeyboardMarkup setKeyboard(List<List<KeyboardButton>> keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Optional<Boolean> getResizeKeyboard() {
        return Optional.ofNullable(resizeKeyboard);
    }

    public ReplyKeyboardMarkup setResizeKeyboard(Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
        return this;
    }

    public Optional<Boolean> getOneTimeKeyboard() {
        return Optional.ofNullable(oneTimeKeyboard);
    }

    public ReplyKeyboardMarkup setOneTimeKeyboard(Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
        return this;
    }

    public Optional<Boolean> getSelective() {
        return Optional.ofNullable(selective);
    }

    public ReplyKeyboardMarkup setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyKeyboardMarkup that = (ReplyKeyboardMarkup) o;
        return keyboard.equals(that.keyboard) &&
                Objects.equals(resizeKeyboard, that.resizeKeyboard) &&
                Objects.equals(oneTimeKeyboard, that.oneTimeKeyboard) &&
                Objects.equals(selective, that.selective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyboard, resizeKeyboard, oneTimeKeyboard, selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + keyboard +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("keyboard", new JSONArray(keyboard.stream()
                .map(keyboardButtons -> new JSONArray(keyboardButtons.stream()
                        .map(KeyboardButton::serializeJSON)
                        .toArray()))
                .toArray()))
                .put("resize_keyboard", resizeKeyboard)
                .put("one_time_keyboard", oneTimeKeyboard)
                .put("selective", selective);
    }
}
