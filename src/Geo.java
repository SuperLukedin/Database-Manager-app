import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Geo {
    private String location;
    private String city;


    public Geo(String location) {
        this.location = location;
        this.city = "newark";
    }

    protected List<Float> getLatLong () {
        List<Float> latLng = new ArrayList<>();
        if (location.length() != 0) {
            Geocoder geocoder = new Geocoder();
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
                    .setAddress(location + ", " + city)
                    .setLanguage("en")
                    .getGeocoderRequest();
            GeocodeResponse geocoderResponse = null;
            try {
                geocoderResponse = geocoder.geocode(geocoderRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<GeocoderResult> result = geocoderResponse.getResults();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //float[] latLng = new float[2];
            if (result.size() != 0) {
                latLng.add(result.get(0).getGeometry().getLocation().getLat().floatValue());
                latLng.add(result.get(0).getGeometry().getLocation().getLng().floatValue());
                return latLng;
            } else {
                return latLng;
            }
        } else {
            return latLng;
        }
    }
}
