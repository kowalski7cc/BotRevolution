package com.kowalski7cc.botrevolution.types.repymarkups;

import org.json.JSONObject;

import java.util.Optional;

public class ForceReply implements ReplyMarkup {

    private Boolean selective;

    public Optional<Boolean> getSelective() {
        return Optional.ofNullable(selective);
    }

    public ForceReply setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("force_reply", true).put("selective", selective);
    }
}
