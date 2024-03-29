package dev.cesarele23.monitorearthquake.earthquakes;

import java.util.Objects;

public class Earthquake {

    private String id;
    private String place;
    private double magnitude;
    private long tome;
    private double longitude;
    private double latitude;

    public Earthquake() {
    }

    public Earthquake(String id, String place, double magnitude, long tome, double longitude, double latitude) {
        this.id = id;
        this.place = place;
        this.magnitude = magnitude;
        this.tome = tome;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getTome() {
        return tome;
    }

    public void setTome(long tome) {
        this.tome = tome;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake that = (Earthquake) o;
        return Double.compare(that.magnitude, magnitude) == 0 && tome == that.tome && Double.compare(that.longitude, longitude) == 0 && Double.compare(that.latitude, latitude) == 0 && Objects.equals(id, that.id) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, magnitude, tome, longitude, latitude);
    }
}
