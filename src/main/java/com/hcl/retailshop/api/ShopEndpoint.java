package com.hcl.retailshop.api;

import com.hcl.retailshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
