package models;

import enums.ListingType;
import enums.RoomType;


public class Property {

    static int counter = 100;
    int propertyID;
    String propertyTitle;
    String location;
    int price;
    ListingType listingType;
    int PropertySize;
    RoomType roomType;
    boolean isPropertySold;

    public Property(String propertyTitle, String location, int price, ListingType listingType,
        int propertySize, RoomType roomType) {
        this.propertyID = counter++;
        this.propertyTitle = propertyTitle;
        this.location = location;
        this.price = price;
        this.listingType = listingType;
        PropertySize = propertySize;
        this.roomType = roomType;
        this.isPropertySold = false;
    }

    public int getPropertyID() {
        return propertyID;
    }

    private void setPropertySold(boolean propertySold) {
        isPropertySold = propertySold;
    }

    public void markPropertyAsSold() {
        if(isPropertySold){
            throw  new RuntimeException("property Sold already");
        }
        setPropertySold(true);
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public int getPropertySize() {
        return PropertySize;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isPropertySold() {
        return isPropertySold;
    }
}