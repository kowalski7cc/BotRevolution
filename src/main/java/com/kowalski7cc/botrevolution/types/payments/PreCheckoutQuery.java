package com.kowalski7cc.botrevolution.types.payments;

import com.kowalski7cc.botrevolution.types.User;

import java.util.Objects;
import java.util.Optional;

public class PreCheckoutQuery {

    private String id;
    private User from;
    private String currency;
    private Integer totalAmount;
    private String invoicePayload;
    private String shippingOptionID;
    private OrderInfo orderInfo;

    public PreCheckoutQuery(String id, User from, String currency, Integer totalAmount, String invoicePayload) {
        this.id = Objects.requireNonNull(id);
        this.from = Objects.requireNonNull(from);
        this.currency = Objects.requireNonNull(currency);
        this.totalAmount = Objects.requireNonNull(totalAmount);
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
    }

    public String getId() {
        return id;
    }

    public PreCheckoutQuery setId(String id) {
        this.id = Objects.requireNonNull(id);
        return this;
    }

    public User getFrom() {
        return from;
    }

    public PreCheckoutQuery setFrom(User from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PreCheckoutQuery setCurrency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public PreCheckoutQuery setTotalAmount(Integer totalAmount) {
        this.totalAmount = Objects.requireNonNull(totalAmount);
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public PreCheckoutQuery setInvoicePayload(String invoicePayload) {
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
        return this;
    }

    public Optional<String> getShippingOptionID() {
        return Optional.ofNullable(shippingOptionID);
    }

    public PreCheckoutQuery setShippingOptionID(String shippingOptionID) {
        this.shippingOptionID = shippingOptionID;
        return this;
    }

    public Optional<OrderInfo> getOrderInfo() {
        return Optional.ofNullable(orderInfo);
    }

    public PreCheckoutQuery setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreCheckoutQuery)) return false;
        PreCheckoutQuery that = (PreCheckoutQuery) o;
        return id.equals(that.id) &&
                from.equals(that.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from);
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionID='" + shippingOptionID + '\'' +
                ", orderInfo=" + orderInfo +
                '}';
    }
}
