package modernpractises.labs.lab03.lab03_02.property;

public class LandlordFactory {
    static public Landlord createLandlord(double buildingMaintenanceCost,double apartmentRent){
        return new Landlord(buildingMaintenanceCost,apartmentRent);
    }
}
