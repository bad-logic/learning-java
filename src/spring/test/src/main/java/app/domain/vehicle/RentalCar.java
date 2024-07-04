package app.domain.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("RentalCar")
public class RentalCar extends Car {
    private double pricePerDay;
    public RentalCar() { }
    public RentalCar(String brand, String color, String licencePlate, double
            pricePerDay) {
        super(brand, color, licencePlate);
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "RentalCar{" +
                "id=" + this.getId() +
                ", brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", pricePerDay=" + this.getPricePerDay() +
                '}';
    }
}