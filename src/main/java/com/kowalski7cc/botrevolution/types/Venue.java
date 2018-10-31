package com.kowalski7cc.botrevolution.types;

import java.util.Objects;
import java.util.Optional;

public class Venue {

    private Location location;
    private String title;
    private String address;
    private String foursquareID;
    private String foursquareType;

    public Venue(Location location, String title, String address) {
        this.location = Objects.requireNonNull(location);
        this.title = Objects.requireNonNull(title);
        this.address = Objects.requireNonNull(address);
    }

    public Location getLocation() {
        return location;
    }

    public Venue setLocation(Location location) {
        this.location = Objects.requireNonNull(location);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Venue setTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Venue setAddress(String address) {
        this.address = Objects.requireNonNull(address);
        return this;
    }

    public Optional<String> getFoursquareID() {
        return Optional.ofNullable(foursquareID);
    }

    public Venue setFoursquareID(String foursquareID) {
        this.foursquareID = foursquareID;
        return this;
    }

    public Optional<String> getFoursquareType() {
        return Optional.ofNullable(foursquareType);
    }

    public Venue setFoursquareType(String foursquareType) {
        this.foursquareType = foursquareType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venue)) return false;
        Venue venue = (Venue) o;
        return location.equals(venue.location) &&
                title.equals(venue.title) &&
                address.equals(venue.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, title, address);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquareID='" + foursquareID + '\'' +
                ", foursquareType='" + foursquareType + '\'' +
                '}';
    }
}
