package dev.cesarele23.monitorearthquake.api;

import com.squareup.moshi.Json;

public class Properties {

    @Json(name="mag")
    private double magnitude;
    private String place;
    private long time;

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
