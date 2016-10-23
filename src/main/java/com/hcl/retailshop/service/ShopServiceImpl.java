package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nitin Shreyakar.
 */
public class ShopServiceImpl implements ShopService {

    private final Set<Shop> shops = new HashSet<>();

    @Override
    public void addShop(Shop shop) {
        shops.add(shop);
    }

    @Override
    public Shop getClosestShop(Coordinates coordinates) {
        for (Shop shop: shops) {
            if (shop.getCoordinates().equals(coordinates)) {
                return shop;
            }
        }
        return null;
    }
}
