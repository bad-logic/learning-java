package app.domain.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("RentalBicycle")
public class RentalBicycle extends Vehicle{
    private double pricePerHour;
    public RentalBicycle() { }
    public RentalBicycle(String brand, String color, double pricePerHour) {
        super(brand, color);
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "RentalBicycle{" +
                "id=" + this.getId() +
                ", brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", pricePerHour=" + this.getPricePerHour() +
                '}';
    }
}
