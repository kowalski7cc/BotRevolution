package com.kowalski7cc.botrevolution.types.repymarkups.replykeyboards;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.Builder;

public class ReplyKeyboardBuilder implements Builder<ReplyKeyboardMarkup> {

    private List<List<KeyboardButton>> keyboard;
    private Boolean resizeKeyboard;
    private Boolean oneTimeKeyboard;
    private Boolean selective;

    public ReplyKeyboardBuilder() {
        keyboard = new LinkedList<>();
    }

    public ReplyKeyboardRowBuilder addRow() {
        return new ReplyKeyboardRowBuilder(this);
    }

    public ReplyKeyboardBuilder setResizeKeyboard(Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
        return this;
    }

    public ReplyKeyboardBuilder setOneTimeKeyboard(Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
        return this;
    }

    public ReplyKeyboardBuilder setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public ReplyKeyboardMarkup build() {
        return new ReplyKeyboardMarkup(keyboard).setResizeKeyboard(resizeKeyboard)
                .setOneTimeKeyboard(oneTimeKeyboard)
                .setSelective(selective);
    }

    public class ReplyKeyboardRowBuilder implements Builder<ReplyKeyboardBuilder> {
        private ReplyKeyboardBuilder parent;
        private List<KeyboardButton> row;

        public ReplyKeyboardRowBuilder(ReplyKeyboardBuilder parent) {
            this.parent = parent;
            row = new LinkedList<>();
        }

        public ReplyKeyboardRowBuilder addButton(KeyboardButton keyboardButton) {
            row.add(keyboardButton);
            return this;
        }

        public KeyboardButtonBuilder buildButton(String text) {
            return new KeyboardButtonBuilder(this, text);
        }

        @Override
        public ReplyKeyboardBuilder build() {
            keyboard.add(row);
            return parent;
        }

        public class KeyboardButtonBuilder implements Builder<ReplyKeyboardRowBuilder> {
            private ReplyKeyboardRowBuilder parent;
            private KeyboardButton keyboardButton;

            public KeyboardButtonBuilder(ReplyKeyboardRowBuilder parent, String text) {
                this.parent = parent;
                keyboardButton = new KeyboardButton(text);
            }

            public KeyboardButtonBuilder setRequestContact(Boolean requestContact) {
                keyboardButton.setRequestContact(requestContact);
                return this;
            }
            public KeyboardButtonBuilder setRequestLocation(Boolean requestLocation) {
                keyboardButton.setRequestLocation(requestLocation);
                return this;
            }

            @Override
            public ReplyKeyboardRowBuilder build() {
                row.add(keyboardButton);
                return parent;
            }
        }
    }
}
