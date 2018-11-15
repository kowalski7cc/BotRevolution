package com.kowalski7cc.botrevolution.types.repymarkups.inlinekeyboard;

import com.kowalski7cc.botrevolution.types.games.CallbackGame;
import org.apache.commons.lang3.builder.Builder;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class InlineKeyboardBuilder implements Builder<InlineKeyboardMarkup> {

    private List<List<InlineKeyboardButton>> inlineKeyboard;
    private int buttons;

    @Override
    public InlineKeyboardMarkup build() {
        return new InlineKeyboardMarkup(inlineKeyboard);
    }

    public class InlineColumnBuilder implements Builder<InlineKeyboardBuilder> {

        private List<InlineKeyboardButton> column;
        private InlineKeyboardBuilder parent;

        public class InlineButtonBuilder implements Builder<InlineColumnBuilder> {

            private InlineKeyboardButton inlineKeyboardButton;
            private InlineColumnBuilder parent;

            public InlineButtonBuilder(String text, InlineColumnBuilder parent) {
                this.inlineKeyboardButton = new InlineKeyboardButton(text);
                this.parent = parent;
            }

            public InlineButtonBuilder setText(String text) {
                inlineKeyboardButton.setUrl(text);
                return this;
            }

            public InlineButtonBuilder setUrl(String url) {
                inlineKeyboardButton.setUrl(url);
                return this;
            }

            public InlineButtonBuilder setUrl(URL url) {
                inlineKeyboardButton.setUrl(url);
                return this;
            }

            public InlineButtonBuilder setCallbackData(String callbackData) {
                inlineKeyboardButton.setUrl(callbackData);
                return this;
            }

            public InlineButtonBuilder setSwitchInlineQuery(String switchInlineQuery) {
                inlineKeyboardButton.setSwitchInlineQuery(switchInlineQuery);
                return this;
            }

            public InlineButtonBuilder setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
                inlineKeyboardButton.setSwitchInlineQueryCurrentChat(switchInlineQueryCurrentChat);
                return this;
            }

            public InlineButtonBuilder setCallbackGame(CallbackGame callbackGame) {
                inlineKeyboardButton.setCallbackGame(callbackGame);
                return this;
            }

            public InlineButtonBuilder addGame() {
                inlineKeyboardButton.setCallbackGame(new CallbackGame());
                return this;
            }

            public InlineButtonBuilder removeGame() {
                inlineKeyboardButton.setCallbackGame(null);
                return this;
            }

            public InlineButtonBuilder addPay() {
                inlineKeyboardButton.setPay(true);
                return this;
            }

            public InlineButtonBuilder removePay() {
                inlineKeyboardButton.setPay(null);
                return this;
            }

            @Override
            public InlineColumnBuilder build() {
                addButton(inlineKeyboardButton);
                return parent;
            }
        }

        public InlineColumnBuilder(InlineKeyboardBuilder parent) {
            this.parent = parent;
            column = new LinkedList<>();
        }

        public InlineColumnBuilder addButton(InlineKeyboardButton button) {
            if (buttons>0) {
                if (button.hasGame() || button.hasPay())
                    throw new UnsupportedOperationException("This type of button must always be the first button in the first row.");
            }
            if (buttons >= 100)
                throw new UnsupportedOperationException("You have reached limit of 100 buttons");
            if (column.size() >= 8)
                throw new UnsupportedOperationException("You have reached limit of 8 buttons per row");
            buttons++;
            column.add(button);
            return this;
        }

        public InlineButtonBuilder buildButton(String text) {
            return new InlineButtonBuilder(text, this);
        }

        @Override
        public InlineKeyboardBuilder build() {
            inlineKeyboard.add(column);
            return parent;
        }
    }

    public InlineKeyboardBuilder() {
        buttons = 0;
        inlineKeyboard = new LinkedList<>();
    }

    public InlineColumnBuilder addColumn() {
        return new InlineColumnBuilder(this);
    }

}
