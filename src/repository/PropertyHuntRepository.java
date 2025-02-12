package repository;

import exceptions.PropertyNotAvailable;
import models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PropertyHuntRepository {
    private HashMap<String, List<Property>> userPropertyMap;

    private HashMap<String, List<Property>> userShortlistedMap;

    private HashMap<Integer, Property> listOfAvailableProperty;

    private String currentUserId;

    private static PropertyHuntRepository propertyHuntRepoInstance;

    private PropertyHuntRepository() {
        this.userPropertyMap = new HashMap<>();
        this.userShortlistedMap = new HashMap<>();
        listOfAvailableProperty = new HashMap<>();
    }

    public static PropertyHuntRepository getInstance() {
        if (propertyHuntRepoInstance == null) {
            propertyHuntRepoInstance = new PropertyHuntRepository();
        }
        return propertyHuntRepoInstance;
    }

    public void addProperty(Property property) {
        if (property != null) {
            if (!userPropertyMap.containsKey(currentUserId)) {
                userPropertyMap.put(currentUserId, new ArrayList<>());
            }
            userPropertyMap.get(currentUserId).add(property);

            listOfAvailableProperty.put(property.getPropertyID(), property);
        }
    }

    public void removeProperty(Integer propertyId){
        listOfAvailableProperty.remove(propertyId);
    }

    public Property getProperty(int propertyId) {
        if (!listOfAvailableProperty.containsKey(propertyId)) {
            throw new PropertyNotAvailable("Property with the property ID not present");
        }
        return listOfAvailableProperty.get(propertyId);
    }

    public void shortListPropertyForCurrentUser(int propertyId) {
        if (!listOfAvailableProperty.containsKey(propertyId)) {
            throw new PropertyNotAvailable("Property with the property ID not present");
        }
        Property property = listOfAvailableProperty.get(propertyId);
        if (!userShortlistedMap.containsKey(currentUserId)) {
            userShortlistedMap.put(currentUserId, new ArrayList<>());
        }
        userShortlistedMap.get(currentUserId).add(property);
        System.out.println("Property Shortlisted " + propertyId + "\n");
    }

    public List<Property> getListedProperty() {
        if (userPropertyMap.containsKey(currentUserId)) {
            return new ArrayList<>(userPropertyMap.get(currentUserId));
        }
        return new ArrayList<>();
    }

    public List<Property> getShortListedProperty() {
        if (userShortlistedMap.containsKey(currentUserId)) {
            return userShortlistedMap.get(currentUserId);
        }
        return new ArrayList<>();
    }

    public String loginNewUser(String userId){
        currentUserId = userId;
        return currentUserId;
    }

    public String getCurrentUser(){
        return currentUserId;
    }

    public HashMap<Integer, Property> getListOfAvailableProperty() {
        return new HashMap<>(listOfAvailableProperty);
    }
}