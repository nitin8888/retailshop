package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.*;

/**
 * Created by Nitin Shreyakar.
 */
@RunWith(SpringRunner.class)
public class ShopServiceTest {

    @InjectMocks
    private ShopServiceImpl shopService;

    @Mock
    private GeocodeService geocodeService;

    @Before
    public void setup() throws Exception {
        when(geocodeService.getCoordinates(anyString(), anyString())).thenAnswer(new Answer<Coordinates>() {
            @Override
            public Coordinates answer(InvocationOnMock invocation) throws Throwable {
                return new Coordinates(1.1, 2.2);
            }
        });
    }

    @Test
    public void processShop() throws Exception {
        URI resource = getClass().getResource("/json/shop.json").toURI();
        String shopJson = new String(Files.readAllBytes(Paths.get(resource)));
        shopService.processShop(shopJson);
        verify(geocodeService, times(1)).getCoordinates(anyString(), anyString());
    }
}
