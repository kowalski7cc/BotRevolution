package com.kowalski7cc.botrevolution.types;

import java.util.Objects;
import java.util.Optional;

public class Contact {

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Integer userID;
    private String vcard;

    public Contact(String phoneNumber, String firstName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
        return this;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Optional<Integer> getUserID() {
        return Optional.ofNullable(userID);
    }

    public Contact setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public Optional<String> getVcard() {
        return Optional.ofNullable(vcard);
    }

    public Contact setVcard(String vcard) {
        this.vcard = vcard;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userID=" + userID +
                ", vcard='" + vcard + '\'' +
                '}';
    }
}
