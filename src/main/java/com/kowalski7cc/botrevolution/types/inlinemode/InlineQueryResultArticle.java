package com.kowalski7cc.botrevolution.types.inlinemode;

public class InlineQueryResultArticle extends InlineQueryResult {

    public InlineQueryResultArticle(String id) {
        super(id);
    }

    @Override
    public InlineQueryType type() {
        return null;
    }
}
