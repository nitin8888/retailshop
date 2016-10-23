package com.hcl.retailshop.model;

/**
 * Created by Nitin Shreyakar.
 */
public class Coordinates {

    /**
     * The geocode longitude.
     */
    private final Integer longitude;

    /**
     * The geocode latitude.
     */
    private final Integer latitude;

    public Coordinates(Integer longitude, Integer latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }
}
