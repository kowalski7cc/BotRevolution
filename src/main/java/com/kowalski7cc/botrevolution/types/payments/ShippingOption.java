package com.kowalski7cc.botrevolution.types.payments;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class ShippingOption implements JSONSerializable {

    private String id;
    private String title;
    private List<LabeledPrice> prices;

    public ShippingOption(String id, String title, List<LabeledPrice> prices) {
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.prices = Objects.requireNonNull(prices);
    }

    public String getId() {
        return id;
    }

    public ShippingOption setId(String id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShippingOption setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public ShippingOption setPrices(List<LabeledPrice> prices) {
        this.prices = Objects.requireNonNull(prices);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingOption)) return false;
        ShippingOption that = (ShippingOption) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShippingOption{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", prices=" + prices +
                '}';
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("id", id)
                .put("title", title)
                .put("prices", new JSONArray(prices.stream().map(labeledPrice -> labeledPrice.serializeJSON())));
    }
}
