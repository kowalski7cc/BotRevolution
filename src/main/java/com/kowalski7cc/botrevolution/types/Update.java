package com.kowalski7cc.botrevolution.types;

import com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard.CallbackQuery;
import com.kowalski7cc.botrevolution.types.inlinemode.ChosenInlineResult;
import com.kowalski7cc.botrevolution.types.inlinemode.InlineQuery;
import com.kowalski7cc.botrevolution.types.payments.PreCheckoutQuery;
import com.kowalski7cc.botrevolution.types.payments.ShippingQuery;

import java.util.Objects;
import java.util.Optional;

public class Update {

    private Integer updateID;
    private Message message;
    private Message editedMessage;
    private Message channelPost;
    private Message editedChannelPost;
    private InlineQuery inlineQuery;
    private ChosenInlineResult chosenInlineResult;
    private CallbackQuery callbackQuery;
    private ShippingQuery shippingQuery;
    private PreCheckoutQuery preCheckoutQuery;

    public Update(Integer updateID) {
        this.updateID = updateID;
    }

    public Integer getUpdateID() {
        return updateID;
    }

    public Update setUpdateID(Integer updateID) {
        this.updateID = Objects.requireNonNull(updateID);
        return this;
    }

    public Optional<Message> getMessage() {
        return Optional.ofNullable(message);
    }

    public Update setMessage(Message message) {
        this.message = message;
        return this;
    }

    public Optional<Message> getEditedMessage() {
        return Optional.ofNullable(editedMessage);
    }

    public Update setEditedMessage(Message editedMessage) {
        this.editedMessage = editedMessage;
        return this;
    }

    public Optional<Message> getChannelPost() {
        return Optional.ofNullable(channelPost);
    }

    public Update setChannelPost(Message channelPost) {
        this.channelPost = channelPost;
        return this;
    }

    public Optional<Message> getEditedChannelPost() {
        return Optional.ofNullable(editedChannelPost);
    }

    public Update setEditedChannelPost(Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
        return this;
    }

    public Optional<InlineQuery> getInlineQuery() {
        return Optional.ofNullable(inlineQuery);
    }

    public Update setInlineQuery(InlineQuery inlineQuery) {
        this.inlineQuery = inlineQuery;
        return this;
    }

    public Optional<ChosenInlineResult> getChosenInlineResult() {
        return Optional.ofNullable(chosenInlineResult);
    }

    public Update setChosenInlineResult(ChosenInlineResult chosenInlineResult) {
        this.chosenInlineResult = chosenInlineResult;
        return this;
    }

    public Optional<CallbackQuery> getCallbackQuery() {
        return Optional.ofNullable(callbackQuery);
    }

    public Update setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
        return this;
    }

    public Optional<ShippingQuery> getShippingQuery() {
        return Optional.ofNullable(shippingQuery);
    }

    public Update setShippingQuery(ShippingQuery shippingQuery) {
        this.shippingQuery = shippingQuery;
        return this;
    }

    public Optional<PreCheckoutQuery> getPreCheckoutQuery() {
        return Optional.ofNullable(preCheckoutQuery);
    }

    public Update setPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery) {
        this.preCheckoutQuery = preCheckoutQuery;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Update)) return false;
        Update update = (Update) o;
        return updateID.equals(update.updateID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateID);
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateID=" + updateID +
                ", message=" + message +
                ", editedMessage=" + editedMessage +
                ", channelPost=" + channelPost +
                ", editedChannelPost=" + editedChannelPost +
                ", inlineQuery=" + inlineQuery +
                ", chosenInlineResult=" + chosenInlineResult +
                ", callbackQuery=" + callbackQuery +
                ", shippingQuery=" + shippingQuery +
                ", preCheckoutQuery=" + preCheckoutQuery +
                '}';
    }
}
