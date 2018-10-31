package com.kowalski7cc.botrevolution.types.payments;

import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;

public class ShippingQuery {

    private String id;
    private User from;
    private String invoicePayload;
    private ShippingAddress shippingAddress;

    public ShippingQuery(String id, User from, String invoicePayload, ShippingAddress shippingAddress) {
        this.id = Objects.requireNonNull(id);
        this.from = Objects.requireNonNull(from);
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
        this.shippingAddress = Objects.requireNonNull(shippingAddress);
    }

    public String getId() {
        return id;
    }

    public ShippingQuery setId(String id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public User getFrom() {
        return from;
    }

    public ShippingQuery setFrom(User from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public ShippingQuery setInvoicePayload(String invoicePayload) {
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
        return this;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public ShippingQuery setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = Objects.requireNonNull(shippingAddress);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingQuery)) return false;
        ShippingQuery that = (ShippingQuery) o;
        return id.equals(that.id) &&
                from.equals(that.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from);
    }

    @Override
    public String toString() {
        return "ShippingQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
