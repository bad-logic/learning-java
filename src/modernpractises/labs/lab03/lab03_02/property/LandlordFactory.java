package modernpractises.labs.lab03.lab03_02.property;

public class LandlordFactory {
    static public Landlord createLandlord(double buildingMaintenanceCost,double apartmentRent){
        Landlord l = new Landlord();
        // at least one building is needed to be a landlord
        Building b = l.addBuilding(buildingMaintenanceCost);
        // at least one apartment is needed in a building
        l.addApartment(b,apartmentRent);
        return l;
    }
}
