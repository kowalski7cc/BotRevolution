package com.kowalski7cc.botrevolution.types.payments;

import java.util.Objects;

public class ShippingAddress {

    private String countryCode;
    private String state;
    private String city;
    private String streetLine1;
    private String streetLine2;
    private String postCode;

    public ShippingAddress(String countryCode, String state, String city,
                           String streetLine1, String streetLine2, String postCode) {
        this.countryCode = Objects.requireNonNull(countryCode);
        this.state = Objects.requireNonNull(state);
        this.city = Objects.requireNonNull(city);
        this.streetLine1 = Objects.requireNonNull(streetLine1);
        this.streetLine2 = Objects.requireNonNull(streetLine2);
        this.postCode = Objects.requireNonNull(postCode);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public ShippingAddress setCountryCode(String countryCode) {
        this.countryCode = Objects.requireNonNull(countryCode);
        return this;
    }

    public String getState() {
        return state;
    }

    public ShippingAddress setState(String state) {
        this.state = Objects.requireNonNull(state);
        return this;
    }

    public String getCity() {
        return city;
    }

    public ShippingAddress setCity(String city) {
        this.city = Objects.requireNonNull(city);
        return this;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public ShippingAddress setStreetLine1(String streetLine1) {
        this.streetLine1 = Objects.requireNonNull(streetLine1);
        return this;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public ShippingAddress setStreetLine2(String streetLine2) {
        this.streetLine2 = Objects.requireNonNull(streetLine2);
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public ShippingAddress setPostCode(String postCode) {
        this.postCode = Objects.requireNonNull(postCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingAddress)) return false;
        ShippingAddress that = (ShippingAddress) o;
        return countryCode.equals(that.countryCode) &&
                state.equals(that.state) &&
                city.equals(that.city) &&
                streetLine1.equals(that.streetLine1) &&
                streetLine2.equals(that.streetLine2) &&
                postCode.equals(that.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "countryCode='" + countryCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
