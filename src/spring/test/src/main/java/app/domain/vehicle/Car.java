package app.domain.vehicle;

import jakarta.persistence.Entity;

@Entity
public abstract class Car extends Vehicle{
    private String licencePlate;
    public Car() { }
    public Car(String brand, String color, String licencePlate) {
        super(brand, color);
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + this.getId() +
                ", brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", licencePlate='" + this.getLicencePlate() + '\'' +
                '}';
    }
}
