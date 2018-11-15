package com.kowalski7cc.botrevolution.types.payments;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import org.json.JSONObject;

import java.util.Objects;

public class LabeledPrice implements JSONSerializable {

    private String label;
    private Integer amount;

    public LabeledPrice(String label, Integer amount) {
        this.label = Objects.requireNonNull(label);
        this.amount = Objects.requireNonNull(amount);
    }

    public String getLabel() {
        return label;
    }

    public LabeledPrice setLabel(String label) {
        this.label = Objects.requireNonNull(label);
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public LabeledPrice setAmount(Integer amount) {
        this.amount = Objects.requireNonNull(amount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LabeledPrice)) return false;
        LabeledPrice that = (LabeledPrice) o;
        return label.equals(that.label) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, amount);
    }

    @Override
    public String toString() {
        return "LabeledPrice{" +
                "label='" + label + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("label", label).put("amount", amount);
    }
}
