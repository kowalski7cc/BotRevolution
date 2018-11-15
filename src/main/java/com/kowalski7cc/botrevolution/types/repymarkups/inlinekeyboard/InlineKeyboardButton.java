package com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import com.kowalski7cc.botrevolution.types.games.CallbackGame;
import org.json.JSONObject;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class InlineKeyboardButton implements JSONSerializable {

    private String text;
    private String url;
    private String callbackData;
    private String switchInlineQuery;
    private String switchInlineQueryCurrentChat;
    private CallbackGame callbackGame;
    private Boolean pay;

    public InlineKeyboardButton(String text) {
        this.text = Objects.requireNonNull(text);
    }

    public String getText() {
        return text;
    }

    public InlineKeyboardButton setText(String text) {
        this.text = Objects.requireNonNull(text);
        return this;
    }

    public Optional<String> getUrl() {
        return Optional.ofNullable(url);
    }

    public InlineKeyboardButton setUrl(String url) {
        this.url = url;
        return this;
    }

    public InlineKeyboardButton setUrl(URL url) {
        this.url = url.toString();
        return this;
    }

    public Optional<String> getCallbackData() {
        return Optional.ofNullable(callbackData);
    }

    public InlineKeyboardButton setCallbackData(String callbackData) {
        this.callbackData = callbackData;
        return this;
    }

    public Optional<String> getSwitchInlineQuery() {
        return Optional.ofNullable(switchInlineQuery);
    }

    public InlineKeyboardButton setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    public Optional<String> getSwitchInlineQueryCurrentChat() {
        return Optional.ofNullable(switchInlineQueryCurrentChat);
    }

    public InlineKeyboardButton setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    public Optional<CallbackGame> getCallbackGame() {
        return Optional.ofNullable(callbackGame);
    }

    public InlineKeyboardButton setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
        return this;
    }

    public InlineKeyboardButton addGame() {
        this.callbackGame = new CallbackGame();
        return this;
    }

    public InlineKeyboardButton removeGame() {
        this.callbackGame = null;
        return this;
    }

    public Boolean hasGame() {
        return callbackGame != null;
    }

    public Optional<Boolean> getPay() {
        return Optional.ofNullable(pay);
    }

    public InlineKeyboardButton setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }

    public InlineKeyboardButton addPay() {
        this.pay = true;
        return this;
    }

    public InlineKeyboardButton removePay() {
        this.pay = null;
        return this;
    }

    public Boolean hasPay() {
        return pay != null && pay.equals(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InlineKeyboardButton that = (InlineKeyboardButton) o;
        return text.equals(that.text) &&
                Objects.equals(url, that.url) &&
                Objects.equals(callbackData, that.callbackData) &&
                Objects.equals(switchInlineQuery, that.switchInlineQuery) &&
                Objects.equals(switchInlineQueryCurrentChat, that.switchInlineQueryCurrentChat) &&
                Objects.equals(callbackGame, that.callbackGame) &&
                Objects.equals(pay, that.pay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, url, callbackData, switchInlineQuery, switchInlineQueryCurrentChat, callbackGame, pay);
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", callbackData='" + callbackData + '\'' +
                ", switchInlineQuery='" + switchInlineQuery + '\'' +
                ", switchInlineQueryCurrentChat='" + switchInlineQueryCurrentChat + '\'' +
                ", callbackGame=" + callbackGame +
                ", pay=" + pay +
                '}';
    }

    @Override
    public JSONObject serializeJSON() {
        JSONObject object = new JSONObject();
        object.put("text", Objects.requireNonNull(text));
        if(url!=null)
            object.put("url",url);
        if (callbackData!=null)
            object.put("callback_data",callbackData);
        if (switchInlineQuery!=null)
            object.put("switch_inline_query", switchInlineQuery);
        if (switchInlineQueryCurrentChat != null)
            object.put("switch_inline_query_current_chat", switchInlineQueryCurrentChat);
        if (callbackGame != null)
            object.put("callback_game", callbackGame.serializeJSON());
        if (pay != null)
            object.put("pay", pay);
        return object;
    }
}
