package com.kowalski7cc.botrevolution.types;

import java.util.Objects;

public class Location {

    private Float longitude;
    private Float latitude;

    public Location(Float longitude, Float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Location setLongitude(Float longitude) {
        this.longitude = Objects.requireNonNull(longitude);
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Location setLatitude(Float latitude) {
        this.latitude = Objects.requireNonNull(latitude);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return longitude.equals(location.longitude) &&
                latitude.equals(location.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
