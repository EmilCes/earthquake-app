package dev.cesarele23.monitorearthquake.api;

import java.util.List;

public class EarthquakeJSONResponse {
    private List<Feature> features;

    public List<Feature> getFeatures(){
        return features;
    }
}
