package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;

/**
 * The Coordinate Service to retrieve longitude and latitude of a address using Google
 * maps geocoding.
 *
 * Created by Nitin Shreyakar.
 */
public interface CoordinateService {
    Coordinates getCoordinates(String addressNumber, String postCode) throws Exception;
}
