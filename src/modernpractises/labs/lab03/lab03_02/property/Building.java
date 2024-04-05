package modernpractises.labs.lab03.lab03_02.property;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Apartment> apartmentList;
    private double maintenanceCost;
    private Landlord landlord;

    Building(Landlord l ,double mc){
        this.landlord = l;
        this.maintenanceCost = mc;
        this.apartmentList = new ArrayList<>();
    }

    void addApartment(double rent){
        this.apartmentList.add(new Apartment(this,rent));
    }

    double getProfit(){
        double profit = 0;
        for(Apartment a: this.apartmentList){
            profit += a.getRent();
        }
        return profit - this.maintenanceCost;
    }

    List<Apartment> getApartments(){
        return this.apartmentList;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Building { maintenanceCost: ");
        sb.append(this.maintenanceCost);
        sb.append(", apartments: [ ");
        for(Apartment a: this.apartmentList){
            sb.append(a.toString());
            sb.append(",");
        }
        sb.append(" ]}");

        return sb.toString();
    }


}
