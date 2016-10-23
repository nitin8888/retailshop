package com.hcl.retailshop.model;

/**
 * Created by Nitin Shreyakar.
 */
public class Shop {

    /**
     * The shop name.
     */
    private String name;

    /**
     * The address number.
     */
    private String addressNumber;

    /**
     * The post code.
     */
    private String postCode;

    /**
     * The geocode Coordinates longitude & latitude.
     */
    private Coordinates coordinates;

    public Shop() {
    }

    public Shop(String name, String addressNumber, String postCode, Coordinates coordinates) {
        this.name = name;
        this.addressNumber = addressNumber;
        this.postCode = postCode;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        if (addressNumber != null ? !addressNumber.equals(shop.addressNumber) : shop.addressNumber != null)
            return false;
        return postCode != null ? postCode.equals(shop.postCode) : shop.postCode == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (addressNumber != null ? addressNumber.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        return result;
    }
}
