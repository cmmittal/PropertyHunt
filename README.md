Your aim is to build a console application for a property platform where users can register, list a property, and find properties matching their requirements.

You need to provide the following options:

Register, Login, and LogOut: A user can sign up and login (No need for Authentication, the name can be considered as the id of the user). Login makes users active and logout makes them inactive.

ListProperty: Users can list properties they are selling.

Search: Users can search for listed properties (only available properties should appear in results). They can use a combination of:
Location (case insensitive exact match would suffice for search).
Price range.
ListingType: Sell/Rent
Size range.
The number of rooms: 1BHK, 2BHK, 3BHK.
Sort by: It could be price or size (only ascending order is required).
Users can choose any set of parameters above for search.

Shortlist: Users can shortlist a property.
ViewShortlisted: Users can view all the shortlisted properties (including sold but with the status should be “sold”).

ViewListed: Users can view properties listed by them.
MarkSold: Users can mark a property sold which was listed by them.

The range can be given as “X-Y” for X to Y inclusive or “X” for more than or equals to X).

Bonus:

Accept size in multiple units (sq. meter, sq. ft. & sq. yard). A seller and a buyer can provide the size in different units while listing and searching properties.

Accept a number of locations as nearby locations for a property listing and search should list properties with search locations in nearby places also (here sort by location can also be provided and such properties which are a match in nearby locations, should appear last).

Accept price in multiple forms (40000, 40k, 2Cr, 60L, etc.) during the listing or searching.
For location and number of rooms, accept “,” separated values during the search.

Input and Output (You may change the input-output format without changing the functionality to suit your needs):

→ is input

← is output

→ ListProperty

← Enter the property details:

→ title A 3BHK for sale, location bellandur, price 90L, type sell, size 1800sqft, rooms 3BHK

← Listing created successfully.

→ ListProperty

← Enter the property details:

→ title A 2BHK for rent, location sarjapur, price 40k, type rent, size 1500sqft, rooms 2BHK, nearby bellandur|kadubeesanahalli|marathahalli

← Listing created successfully.

→ login tej

← Welcome tej

→ search location bellandur, pricerange 30000-50000, type rent, sizerange 150sqft, rooms 2BHK, sort price

← Id	Title			Location	Price	Size	Rooms	AvailableFor

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent

→ ShortList 2

← Shortlisted

← ViewShortlisted

← Id	Title			Location	Price	Size	Rooms	AvailableFor	Status

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent		Available

→ search

← Id	Title			Location	Price	Size	Rooms	AvailableFor

← 1	A 3BHK for sale	bellandur	90L	1800sqf 3BHK	Sale

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent