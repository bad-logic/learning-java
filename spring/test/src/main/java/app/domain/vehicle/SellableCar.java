package app.domain.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("SellableCar")
public class SellableCar extends Car {
    private double sellPrice;
    public SellableCar() { }
    public SellableCar(String brand, String color, String licencePlate, double
            sellPrice) {
        super(brand, color, licencePlate);
        this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "SellableCar{" +
                "id=" + this.getId() +
                ", brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", sellPrice=" + this.getSellPrice() +
                '}';
    }
}
