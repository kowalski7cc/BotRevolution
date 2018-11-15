package com.kowalski7cc.botrevolution.types.repymarkups.replykeyboards;

import com.kowalski7cc.botrevolution.types.repymarkups.ReplyMarkup;
import org.json.JSONObject;

import java.util.Optional;

public class ReplyKeyboardRemove implements ReplyMarkup {

    private Boolean selective;

    public Optional<Boolean> getSelective() {
        return Optional.ofNullable(selective);
    }

    public ReplyKeyboardRemove setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("remove_keyboard", true)
                .putOpt("selective", selective);
    }
}
