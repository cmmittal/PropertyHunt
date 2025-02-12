package Util;

import java.util.List;

import models.Property;

public class PrintPropertyUtil {

    public static void print(List<Property> propertyList){
        for (Property property : propertyList) {
            System.out.println(
                "PropertyID : " + property.getPropertyID() + " | Title : " + property.getPropertyTitle() + " | Location : " + property.getLocation() + " | Price : "
                    + property.getPrice() + " | Size : " + property.getPropertySize() + "sqft | RoomType : " + property.getRoomType() + " | ListingType : "
                    + property.getListingType() + " | IsSold : " + property.isPropertySold() + "\n");
        }
    }
}
