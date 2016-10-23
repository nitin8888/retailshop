package com.hcl.retailshop.api;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;
import com.hcl.retailshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The Shop Endpoint for posting and getting shop.
 *
 * Created by Nitin Shreyakar.
 */
@RestController
public class ShopEndpoint {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public void pushShop(@RequestBody String body) throws Exception {
        shopService.processShop(body);
    }

    @RequestMapping(value = "/closestShop", method = RequestMethod.GET)
    public Shop getClosestShop(@RequestParam(value = "latitude") double latitude,
                               @RequestParam(value = "longitude") double longitude) throws Exception {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        Shop closestShop = shopService.getClosestShop(coordinates);
        return closestShop;
    }
}
