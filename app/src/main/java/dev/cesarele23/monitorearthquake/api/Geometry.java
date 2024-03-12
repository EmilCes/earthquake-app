package dev.cesarele23.monitorearthquake.api;

public class Geometry {

    private double[] coordinates;

    public double getLongitude(){
        return coordinates[0];
    }

    public double getLatitudes(){
        return coordinates[1];
    }

}
