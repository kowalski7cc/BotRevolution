package com.kowalski7cc.botrevolution.types.payments;

import java.util.Objects;
import java.util.Optional;

public class SuccessfulPayment {

    private String currency;
    private Integer totalAmount;
    private String invoicePayload;
    private String shippingOptionID;
    private OrderInfo orderInfo;
    private String telegramPaymentChargeID;
    private String providerPaymentChargeID;

    public SuccessfulPayment(String currency, Integer totalAmount, String invoicePayload,
                             String telegramPaymentChargeID, String providerPaymentChargeID) {
        this.currency = Objects.requireNonNull(currency);
        this.totalAmount = Objects.requireNonNull(totalAmount);
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
        this.telegramPaymentChargeID = Objects.requireNonNull(telegramPaymentChargeID);
        this.providerPaymentChargeID = Objects.requireNonNull(providerPaymentChargeID);
    }

    public String getCurrency() {
        return currency;
    }

    public SuccessfulPayment setCurrency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public SuccessfulPayment setTotalAmount(Integer totalAmount) {
        this.totalAmount = Objects.requireNonNull(totalAmount);
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public SuccessfulPayment setInvoicePayload(String invoicePayload) {
        this.invoicePayload = Objects.requireNonNull(invoicePayload);
        return this;
    }

    public String getTelegramPaymentChargeID() {
        return telegramPaymentChargeID;
    }

    public SuccessfulPayment setTelegramPaymentChargeID(String telegramPaymentChargeID) {
        this.telegramPaymentChargeID = Objects.requireNonNull(telegramPaymentChargeID);
        return this;
    }

    public String getProviderPaymentChargeID() {
        return providerPaymentChargeID;
    }

    public SuccessfulPayment setProviderPaymentChargeID(String providerPaymentChargeID) {
        this.providerPaymentChargeID = Objects.requireNonNull(providerPaymentChargeID);
        return this;
    }

    public Optional<String> getShippingOptionID() {
        return Optional.ofNullable(shippingOptionID);
    }

    public SuccessfulPayment setShippingOptionID(String shippingOptionID) {
        this.shippingOptionID = shippingOptionID;
        return this;
    }

    public Optional<OrderInfo> getOrderInfo() {
        return Optional.ofNullable(orderInfo);
    }

    public SuccessfulPayment setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuccessfulPayment)) return false;
        SuccessfulPayment that = (SuccessfulPayment) o;
        return currency.equals(that.currency) &&
                totalAmount.equals(that.totalAmount) &&
                invoicePayload.equals(that.invoicePayload) &&
                Objects.equals(shippingOptionID, that.shippingOptionID) &&
                Objects.equals(orderInfo, that.orderInfo) &&
                telegramPaymentChargeID.equals(that.telegramPaymentChargeID) &&
                providerPaymentChargeID.equals(that.providerPaymentChargeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, totalAmount, invoicePayload, shippingOptionID,
                orderInfo, telegramPaymentChargeID, providerPaymentChargeID);
    }

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionID='" + shippingOptionID + '\'' +
                ", orderInfo=" + orderInfo +
                ", telegramPaymentChargeID='" + telegramPaymentChargeID + '\'' +
                ", providerPaymentChargeID='" + providerPaymentChargeID + '\'' +
                '}';
    }
}
