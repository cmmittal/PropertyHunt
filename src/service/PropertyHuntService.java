package service;

import Util.SearchPropertyUtil; 
import Util.PrintPropertyUtil;
import enums.ListingType;
import enums.RoomType;
import models.Property;
import repository.PropertyHuntRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyHuntService {

    PropertyHuntRepository propertyHuntRepo;

    public PropertyHuntService() {
        this.propertyHuntRepo = PropertyHuntRepository.getInstance();
    }

    public void listProperty(String propertyTitle, String location, int price,
        ListingType listingType,
        int propertySize,
        RoomType roomType) {
        
        Property property = new Property(propertyTitle, location, price, listingType, propertySize,
            roomType);

        propertyHuntRepo.addProperty(property);
        System.out.println("List Created successfully for the propertyTitle : " + propertyTitle + "\n");
    }

    public void shortListProperty(int propertyID) {
        Property property = propertyHuntRepo.getProperty(propertyID);
        if (property != null) {
            propertyHuntRepo.shortListPropertyForCurrentUser(propertyID);
        }
    }

    public void viewShortListProperty() {
        List<Property> propertyList = propertyHuntRepo.getShortListedProperty();
        
        PrintPropertyUtil.print(propertyList);
    }

    public void viewListedProperty() {
        List<Property> propertyList = propertyHuntRepo.getListedProperty();
        PrintPropertyUtil.print(propertyList);
    }

    public void markAsSold(int propertyId, String soldTo, String soldPrice) {
        List<Property> propertyList = propertyHuntRepo.getListedProperty();
        boolean canPropertyBeSold = false;
        for (Property property : propertyList) {
            if (property.getPropertyID() == propertyId) {
                canPropertyBeSold = true;
                break;
            }
        }
        if (!canPropertyBeSold) {
            throw new RuntimeException("property can't be sold as your are a different user");
        }
        Property property = propertyHuntRepo.getProperty(propertyId);
        if (property != null) {
            property.markPropertyAsSold();
        }

        propertyHuntRepo.removeProperty(propertyId);

        System.out.println("Property Marked as sold with PropertyId : " + propertyId + "\n");
    }

    public void searchProperty(String location, String price, ListingType listingType, String size, RoomType roomType, String sortBasis) {

        HashMap<Integer, Property> map = propertyHuntRepo.getListOfAvailableProperty();
        List<Property> propertyList = new ArrayList<>();
        for (Map.Entry<Integer, Property> entry : map.entrySet()) {
            propertyList.add(entry.getValue());
        }

        if (location != null && !location.equals(""))
            propertyList = SearchPropertyUtil.filterByLocation(location, propertyList);
        if (price != null && !price.equals(""))
            propertyList = SearchPropertyUtil.filterByPriceRange(price, propertyList);
        if (listingType != null)
            propertyList = SearchPropertyUtil.filterByListingType(listingType, propertyList);
        if (size != null && !size.equals(""))
            propertyList = SearchPropertyUtil.filterBySize(size, propertyList);
        if (roomType != null)
            propertyList = SearchPropertyUtil.filterByNumberOfRooms(roomType, propertyList);


        if (sortBasis != null && sortBasis.equals("price")) {
            Collections.sort(propertyList, Comparator.comparingInt(p -> p.getPrice()));
        }
        else if (sortBasis != null && sortBasis.equals("size")) {
            Collections.sort(propertyList, Comparator.comparingInt(p -> p.getPropertySize()));
        }
        PrintPropertyUtil.print(propertyList);
    }

    public void loginUser(String userId) {
        if (propertyHuntRepo.getCurrentUser() != null) {
            throw new RuntimeException("A User is already logged in");
        }
        propertyHuntRepo.loginNewUser(userId);
        System.out.println("Current user logged in : " + userId + "\n");
    }

    public void logoutUser(String userId) {
        String currentUser = propertyHuntRepo.getCurrentUser();
        if (currentUser != null && !currentUser.equals(userId)) {
            throw new RuntimeException("User is not logged in");
        }

        propertyHuntRepo.loginNewUser(null);

        System.out.println(userId + " user logged out \n");
    }
}