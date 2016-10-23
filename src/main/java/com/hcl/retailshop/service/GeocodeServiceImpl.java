package com.hcl.retailshop.service;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.hcl.retailshop.model.Coordinates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The Coordinate Service to retrieve longitude and latitude of a address using Google
 * maps geocoding.
 *
 * Created by Nitin Shreyakar.
 */
@Service
public class GeocodeServiceImpl implements GeocodeService {

    /**
     * Google API Key.
     */
    private static final String API_KEY = "AIzaSyDvvNZPqP00fjLndLxgcl8qxMWzUVVSXD4";

    @Override
    public Coordinates getCoordinates(String addressNumber, String postCode) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        GeocodingResult[] results =  GeocodingApi.geocode(context, addressNumber + "," + postCode).await();
        if (results != null && results.length > 0) {
            LatLng location = results[0].geometry.location;
            return new Coordinates(location.lat, location.lng);
        } else {
            throw new IllegalArgumentException("Could not find coordinates for addressNumber:" + addressNumber
                + " Post code:" + postCode);
        }
    }

    @Override
    public int getClosestCoordinates(Coordinates customerCoordinates, List<Coordinates> shopCoordinates) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        LatLng customerLatLng = getLatLng(customerCoordinates);
        LatLng[] shopLatLngList = getLatLng(shopCoordinates);
        DistanceMatrix results = new DistanceMatrixApiRequest(context).origins(customerLatLng).destinations(shopLatLngList)
                .await();

        if (results != null) {
            DistanceMatrixRow[] rows = results.rows;
            if (rows.length > 0) {
                List<DistanceMatrixElement> elements = Arrays.asList(rows[0].elements);

                int minIndex = IntStream.range(0,elements.size())
                        .reduce((i,j) -> (elements.get(i)).distance.inMeters > (elements.get(j)).distance.inMeters ? j : i)
                        .getAsInt();  // or throw

                return minIndex;

            }
        } else {
            throw new IllegalArgumentException("Could not find minimum distance");
        }
        return 0;
    }

    /**
     * Get LatLng for Coordinates.
     * @param coordinates the Coordinates
     * @return the LatLng
     */
    private LatLng getLatLng(Coordinates coordinates) {
        return new LatLng(coordinates.getLatitude(), coordinates.getLongitude());
    }

    /**
     * Get array of LatLng for list of Coordinates.
     * @param coordinatesList the list of Coordinates
     * @return the array of LatLng
     */
    private LatLng[] getLatLng(List<Coordinates> coordinatesList) {
        List<LatLng> coordinatesResult = new ArrayList<>(coordinatesList.size());
        for (Coordinates coordinates: coordinatesList) {
            coordinatesResult.add(getLatLng(coordinates));
        }
        return coordinatesResult.toArray(new LatLng[0]);
    }
}
