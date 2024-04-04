package modernpractises.labs.lab03.lab03_02;

import modernpractises.labs.lab03.lab03_02.property.Building;
import modernpractises.labs.lab03.lab03_02.property.Landlord;
import modernpractises.labs.lab03.lab03_02.property.LandlordFactory;

public class Main {

    public static void main(String[] args){

        Landlord landlord = LandlordFactory.createLandlord(999.99,500);
        Building a = landlord.getBuildings().getFirst();
        landlord.addApartment(a,679.69);
        landlord.addApartment(a,1679.69);
        landlord.addApartment(a,779.69);

        Building b = landlord.addBuilding(1300.55);
        landlord.addApartment(b,640);
        landlord.addApartment(b,1543);
        landlord.addApartment(b,844);

        Building c = landlord.addBuilding(1549.69);
        landlord.addApartment(c,666.66);
        landlord.addApartment(c,664.89);
        landlord.addApartment(c,1664.89);

        System.out.println(landlord);
//        System.out.println(a);

        System.out.println(landlord.getMonthlyProfit());
    }
}
