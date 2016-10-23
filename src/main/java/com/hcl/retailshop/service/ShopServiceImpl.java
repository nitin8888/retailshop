package com.hcl.retailshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The shop service to add shop and get closest shop.
 *
 * Created by Nitin Shreyakar.
 */
@Service
public class ShopServiceImpl implements ShopService {

    private static final List<Shop> SHOPS = new ArrayList<>();

    @Autowired
    private GeocodeService geocodeService;

    @Override
    public Shop getClosestShop(Coordinates customerCoordinates) throws Exception {
        if (!SHOPS.isEmpty()) {
            List<Coordinates> shopCoordinates = new ArrayList<>(SHOPS.size());
            for (Shop shop: SHOPS) {
                shopCoordinates.add(shop.getCoordinates());
            }
            int closestIndex = geocodeService.getClosestCoordinates(customerCoordinates, shopCoordinates);
            return SHOPS.get(closestIndex);
        } else {
            return null;
        }
    }

    @Override
    public void processShop(String shopJson) throws Exception {
        Shop shop = new ObjectMapper().readValue(shopJson, Shop.class);
        Coordinates coordinates = geocodeService.getCoordinates(shop.getAddressNumber(), shop.getPostCode());
        shop.setCoordinates(coordinates);

        // Avoid duplicate shops to be added
        if (!SHOPS.contains(shop)) {
            SHOPS.add(shop);
        }
    }
}
