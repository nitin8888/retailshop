package com.hcl.retailshop.model;

/**
 * The Coordinates object to store longitude and latitude.
 *
 * Created by Nitin Shreyakar.
 */
public class Coordinates {

    /**
     * The geocode longitude.
     */
    private final double longitude;

    /**
     * The geocode latitude.
     */
    private final double latitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
