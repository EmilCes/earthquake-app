package dev.cesarele23.monitorearthquake.api;

import java.util.ArrayList;
import java.util.List;

import dev.cesarele23.monitorearthquake.earthquakes.Earthquake;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public interface DownloadEqListener {
        void onEqsDownloaded(List<Earthquake> eqList);
    }

    private List<Earthquake> getEarthquakesWithMoshi(EarthquakeJSONResponse body){
        ArrayList<Earthquake> eqList = new ArrayList<>();

        List<Feature> features = body.getFeatures();
        for (Feature feature: features) {
            String id = feature.getId();
            double magnitude = feature. getProperties (). getMagnitude () ;
            String place = feature.getProperties (). getPlace () ;
            long time = feature.getProperties().getTime();

            double longitude = feature.getGeometry().getLongitude();
            double latitude = feature.getGeometry().getLatitudes();

            Earthquake earthquake = new Earthquake (id, place, magnitude, time,
                    latitude, longitude) ;
            eqList. add (earthquake);
        }

        return eqList;
    }

    public void getEarthquakes(DownloadEqListener downloadEqListener) {
        ApiClient.Service service = ApiClient.getInstance().getService();
        service.getEarthquakes().enqueue(new Callback<EarthquakeJSONResponse>() {
            @Override
            public void onResponse(Call<EarthquakeJSONResponse> call, Response<EarthquakeJSONResponse> response) {
                List<Earthquake> earthquakesList = getEarthquakesWithMoshi(response.body());
                downloadEqListener.onEqsDownloaded(earthquakesList);
            }

            @Override
            public void onFailure(Call<EarthquakeJSONResponse> call, Throwable t) {

            }
        });
    }
}
