package modernpractises.labs.lab03.lab03_02.property;

public class Apartment {
    private double rent;
    private Building building;
    Apartment(Building b,double r){
        this.building = b;
        this.rent = r;
    }

    double getRent(){
        return this.rent;
    }

    public String toString(){
        return "Apartment { rent: " + this.rent + " }";
    }
}
