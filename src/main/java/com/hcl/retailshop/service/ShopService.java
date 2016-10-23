package com.hcl.retailshop.service;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;

/**
 * The shop service to add shop and get closest shop.
 *
 * Created by Nitin Shreyakar.
 */
public interface ShopService {

    /**
     * Gets the closest shop to the passed coordinates.
     * @param coordinates the coordinates used for querying.
     * @return the closest shop
     */
    Shop getClosestShop(Coordinates coordinates) throws Exception;

    /**
     * Process shop by parsing the json file.
     * @param shopJson the shop json file
     * @throws Exception if any error occurs
     */
    void processShop(String shopJson) throws Exception;
}
