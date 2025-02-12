package Util;

import enums.ListingType;
import enums.RoomType;
import models.Property;

import java.util.ArrayList;
import java.util.List;


public class SearchPropertyUtil {
    public static List<Property> filterByLocation(String location, List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getLocation().equals(location.toLowerCase())){
                list.add(property);
            }
        }
        return list;
    }


    public static List<Property> filterByListingType(ListingType listingType,List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getListingType().equals(listingType)){
                list.add(property);
            }
        }
        return list;
    }

    public static List<Property> filterByNumberOfRooms(RoomType roomType,List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getRoomType().equals(roomType)){
                list.add(property);
            }
        }
        return list;
    }

    public static List<Property> filterByPriceRange(String range, List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        String[] lowAndHighRange = range.split("-");
        int lower = Integer.parseInt(lowAndHighRange[0]);
        int higher = Integer.parseInt(lowAndHighRange[1]);

        for (Property property : propertyList) {
            if (property.getPrice() >= lower && property.getPrice() <= higher) {
                list.add(property);
            }
        }
        return list;
    }

    public static List<Property> filterBySize(String range, List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        String[] lowAndHighRange = range.split("-");
        int lower = Integer.parseInt(lowAndHighRange[0]);
        int higher = Integer.parseInt(lowAndHighRange[1]);

        for (Property property : propertyList) {
            if (property.getPropertySize() >= lower && property.getPropertySize() <= higher) {
                list.add(property);
            }
        }
        return list;
    }

    public static List<Property> filterSoldOut(List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();

        for (Property property : propertyList) {
            if (!property.isPropertySold()) {
                list.add(property);
            }
        }

        return list;
    }
}