package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Nitin Shreyakar.
 */
@RunWith(SpringRunner.class)
public class GeocodeServiceTest {

    private final CoordinateService coordinateService = new CoordinateServiceImpl();

    @Test
    public void getCoordinates() throws Exception {
        String addressNumber = "24";
        String postCode = "EC1Y 4TY";
        Coordinates coordinates = coordinateService.getCoordinates(addressNumber, postCode);
        assertNotNull("Coordinates should be present", coordinates);
    }
}
