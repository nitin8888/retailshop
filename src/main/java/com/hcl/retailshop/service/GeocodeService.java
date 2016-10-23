package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;

import java.util.List;

/**
 * The Coordinate Service to retrieve longitude and latitude of a address using Google
 * maps geocoding.
 *
 * Created by Nitin Shreyakar.
 */
public interface GeocodeService {
    /**
     * Get coordinates for address number and post code.
     * @param addressNumber the address number
     * @param postCode the post code
     * @return the coordinates in latitude and longitude
     * @throws Exception if any error occurs
     */
    Coordinates getCoordinates(String addressNumber, String postCode) throws Exception;

    /**
     * Get closest shop coordinates from a list of shop coordinates for a customer coordinates.
     *
     * @param customerCoordinates the customer coordinates
     * @param shopCoordinates the list of shop coordinates
     * @return the index of the closest shop
     * @throws Exception if any error occurs
     */
    int getClosestCoordinates(Coordinates customerCoordinates, List<Coordinates> shopCoordinates) throws Exception;
}
