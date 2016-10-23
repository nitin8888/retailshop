package com.hcl.retailshop.api;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.retailshop.model.Shop;
import com.hcl.retailshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Nitin Shreyakar.
 */
@RestController
//@AutoConfigurationPackage
//@RequestMapping("/pubsub")
public class ShopEndpoint {

    @Resource
    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public void pushShop(@RequestBody String body) throws IOException {

//        JsonParser parser = JacksonFactory.getDefaultInstance().createJsonParser(body);
//        parser.skipToKey("message");

        Shop shop = new ObjectMapper().readValue(body, Shop.class);
        shopService.addShop(shop);
    }
}
