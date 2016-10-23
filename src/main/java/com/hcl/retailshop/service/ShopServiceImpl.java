package com.hcl.retailshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * The shop service to add shop and get closest shop.
 *
 * Created by Nitin Shreyakar.
 */
@Service
public class ShopServiceImpl implements ShopService {

    private static final Set<Shop> SHOPS = new HashSet<>();

    @Autowired
    private CoordinateService coordinateService;

    @Override
    public Shop getClosestShop(Coordinates coordinates) {
        for (Shop shop: SHOPS) {
            if (shop.getCoordinates().equals(coordinates)) {
                return shop;
            }
        }
        return null;
    }

    @Override
    public void processShop(String shopJson) throws Exception {
        Shop shop = new ObjectMapper().readValue(shopJson, Shop.class);
        Coordinates coordinates = coordinateService.getCoordinates(shop.getAddressNumber(), shop.getPostCode());
        shop.setCoordinates(coordinates);
        SHOPS.add(shop);
    }
}
