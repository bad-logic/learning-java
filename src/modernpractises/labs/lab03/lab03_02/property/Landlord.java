package modernpractises.labs.lab03.lab03_02.property;


import java.util.ArrayList;
import java.util.List;

public class Landlord {
    List<Building> buildingList;
    Landlord(){
        this.buildingList  =  new ArrayList<>();
    }

    public Building addBuilding(double mc){
        Building nb = new Building(this,mc);
        buildingList.add(nb);
        return nb;
    }

    public void addApartment(Building b,double r){
        b.addApartment(r);
    }

    public double getMonthlyProfit(){
        double profit = 0;
        for(Building b: buildingList){
            profit += b.getProfit();
        }
        return profit;
    }

    public List<Building> getBuildings(){
        return this.buildingList;
    }

    public List<Apartment> getApartments(Building b){
        return b.getApartments();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Landlord { \nbuildings: [ \n");
        for(Building b: buildingList){
            sb.append(b.toString());
            sb.append(",\n");
        }
        sb.append("]\n}");
        return sb.toString();
    }
}