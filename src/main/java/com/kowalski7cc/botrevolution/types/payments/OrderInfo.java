package com.kowalski7cc.botrevolution.types.payments;

import java.util.Objects;
import java.util.Optional;

public class OrderInfo {

    private String name;
    private String phoneNumber;
    private String email;
    private ShippingAddress shippingAddress;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public OrderInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }

    public OrderInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public OrderInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public Optional<ShippingAddress> getShippingAddress() {
        return Optional.ofNullable(shippingAddress);
    }

    public OrderInfo setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderInfo)) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return Objects.equals(name, orderInfo.name) &&
                Objects.equals(phoneNumber, orderInfo.phoneNumber) &&
                Objects.equals(email, orderInfo.email) &&
                Objects.equals(shippingAddress, orderInfo.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email, shippingAddress);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
