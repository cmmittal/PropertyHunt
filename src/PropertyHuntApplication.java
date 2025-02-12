import enums.ListingType;
import enums.RoomType;
import service.PropertyHuntService;

public class PropertyHuntApplication {
    public static void main(String[] args) {
        PropertyHuntService propertyHuntService = new PropertyHuntService();

        propertyHuntService.loginUser("Seller");

        propertyHuntService
            .listProperty("A 3BHK for sale", "bellandur", 9000000, ListingType.SELL, 1800, RoomType.THREEBHK);

        propertyHuntService
            .listProperty("A 2BHK for sale", "sarjapura", 40000, ListingType.RENT, 1500, RoomType.TWOBHK);
 
        propertyHuntService.logoutUser("Seller");


        propertyHuntService.loginUser("Tej");


        propertyHuntService.searchProperty("sarjapura", "30000-50000", ListingType.RENT, "1000-1700", RoomType.TWOBHK, "price");

        propertyHuntService.shortListProperty(101);

        propertyHuntService.viewShortListProperty();

        propertyHuntService.logoutUser("Tej");


        propertyHuntService.loginUser("Seller");
        propertyHuntService.markAsSold(101, "Tej", "40000");

        propertyHuntService.searchProperty(null, null, null, null, null, null);

        propertyHuntService.logoutUser("Seller");
        propertyHuntService.loginUser("Tej");

        propertyHuntService.viewShortListProperty();
    }
}