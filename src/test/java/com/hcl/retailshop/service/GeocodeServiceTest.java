package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Nitin Shreyakar.
 */
@RunWith(SpringRunner.class)
public class GeocodeServiceTest {

    private final GeocodeService geocodeService = new GeocodeServiceImpl();

    @Test
    public void getCoordinates() throws Exception {
        String addressNumber = "24";
        String postCode = "EC1Y 4TY";
        Coordinates coordinates = geocodeService.getCoordinates(addressNumber, postCode);
        assertNotNull("Coordinates should be present", coordinates);
    }

    @Test
    public void getClosestCoordinate() throws Exception {
        Coordinates customerCoordinates = new Coordinates(51.5217644,-0.093038);
        List<Coordinates> shopCoordinates = new ArrayList<>();
        shopCoordinates.add(new Coordinates(51.5476586,-0.1087451));    // Far. i=0
        shopCoordinates.add(new Coordinates(51.5208698,-0.0917935));    // Closest. i=1
        shopCoordinates.add(new Coordinates(51.5241943,-0.0976729));    // Far. i=2
        int index = geocodeService.getClosestCoordinates(customerCoordinates, shopCoordinates);
        assertEquals("Shop 1 should be the closest shop to the customer", index, 1);
    }
}
