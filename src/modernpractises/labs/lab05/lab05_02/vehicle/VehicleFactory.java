package modernpractises.labs.lab05.lab05_02.vehicle;

public class VehicleFactory {
    private VehicleFactory(){}

    public static Vehicle getVehicle(String v){
        switch (v.toLowerCase()){
            case "car":
                return new Car();
            case "bus":
                return new Bus();
            case "truck":
                return new Truck();
            case "electriccar":
                return new ElectricCar();
            default:
                System.out.println(v + " : Unrecognized vehicle type");
                return null;
        }
    }
}
