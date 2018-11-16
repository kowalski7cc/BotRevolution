package com.kowalski7cc.botrevolution.types.repymarkups.replykeyboards;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Optional;

public class KeyboardButton implements JSONSerializable {

    private String text;
    private Boolean requestContact;
    private Boolean requestLocation;

    public KeyboardButton(String text) {
        this.text = Objects.requireNonNull(text);
    }

    public KeyboardButton(String text, Boolean requestContact, Boolean requestLocation) {
        this.text = Objects.requireNonNull(text);
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
    }

    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    public KeyboardButton setText(String text) {
        this.text = Objects.requireNonNull(text);
        return this;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public KeyboardButton setRequestContact(Boolean requestContact) {
        this.requestContact = requestContact;
        return this;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }

    public KeyboardButton setRequestLocation(Boolean requestLocation) {
        this.requestLocation = requestLocation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyboardButton that = (KeyboardButton) o;
        return text.equals(that.text) &&
                Objects.equals(requestContact, that.requestContact) &&
                Objects.equals(requestLocation, that.requestLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, requestContact, requestLocation);
    }

    @Override
    public String toString() {
        return "KeyboardButton{" +
                "text='" + text + '\'' +
                ", requestContact=" + requestContact +
                ", requestLocation=" + requestLocation +
                '}';
    }

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("text", text)
                .put("request_contact", requestContact)
                .put("request_location", requestLocation);
    }
}
