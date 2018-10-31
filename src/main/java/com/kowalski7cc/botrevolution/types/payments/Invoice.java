package com.kowalski7cc.botrevolution.types.payments;

import java.util.Objects;

public class Invoice {

    private String title;
    private String description;
    private String startParameter;
    private String currency;
    private Integer totalAmount;

    public Invoice(String title, String description, String startParameter, String currency, Integer totalAmount) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.startParameter = Objects.requireNonNull(startParameter);
        this.currency = Objects.requireNonNull(currency);
        this.totalAmount = Objects.requireNonNull(totalAmount);
    }

    public String getTitle() {
        return title;
    }

    public Invoice setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Invoice setDescription(String description) {
        this.description = Objects.requireNonNull(description);
        return this;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public Invoice setStartParameter(String startParameter) {
        this.startParameter = Objects.requireNonNull(startParameter);
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Invoice setCurrency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public Invoice setTotalAmount(Integer totalAmount) {
        this.totalAmount = Objects.requireNonNull(totalAmount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return title.equals(invoice.title) &&
                description.equals(invoice.description) &&
                startParameter.equals(invoice.startParameter) &&
                currency.equals(invoice.currency) &&
                totalAmount.equals(invoice.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, startParameter, currency, totalAmount);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startParameter='" + startParameter + '\'' +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
