package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;

/**
 * Created by Nitin Shreyakar.
 */
public interface ShopService {

    /**
     * Add shop to the collection of shops.
     */
    void addShop(Shop shop);

    /**
     * Gets the closest shop to the passed coordinates.
     * @param coordinates the coordinates used for querying.
     * @return the closest shop
     */
    Shop getClosestShop(Coordinates coordinates);
}
