package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Nitin Shreyakar.
 */
@RunWith(SpringRunner.class)
public class ShopServiceTest {

    @Test
    public void addShop() {

        Coordinates coordinates = new Coordinates(123, 456);
        Shop shop = new Shop("Tesco", "24", "EC2 3DY", coordinates);
        ShopService shopService = new ShopServiceImpl();
        shopService.addShop(shop);
        Shop closestShop = shopService.getClosestShop(coordinates);

        assertEquals("The created shop should be the closest shop", shop, closestShop);
    }
}
