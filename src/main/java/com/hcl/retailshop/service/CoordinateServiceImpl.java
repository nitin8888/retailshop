package com.hcl.retailshop.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.hcl.retailshop.model.Coordinates;
import org.springframework.stereotype.Service;

/**
 * The Coordinate Service to retrieve longitude and latitude of a address using Google
 * maps geocoding.
 *
 * Created by Nitin Shreyakar.
 */
@Service
public class CoordinateServiceImpl implements CoordinateService {

    private static final String API_KEY = "AIzaSyDvvNZPqP00fjLndLxgcl8qxMWzUVVSXD4";

    @Override
    public Coordinates getCoordinates(String addressNumber, String postCode) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        GeocodingResult[] results =  GeocodingApi.geocode(context, addressNumber + "," + postCode).await();
        if (results != null && results.length > 0) {
            LatLng location = results[0].geometry.location;
            return new Coordinates(location.lng, location.lat);
        } else {
            throw new IllegalArgumentException("Could not find coordinates for addressNumber:" + addressNumber
                + " Post code:" + postCode);
        }
    }
}
