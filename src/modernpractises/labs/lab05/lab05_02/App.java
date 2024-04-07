package modernpractises.labs.lab05.lab05_02;

import modernpractises.labs.lab05.lab05_02.vehicle.Vehicle;
import modernpractises.labs.lab05.lab05_02.vehicle.VehicleFactory;

public class App {

    public static void main(String[] args){

        String[] vehicles = {"car","Truck","ElectricCar","Bus","flyingCar"};

        for(String vehicle: vehicles ){
           Vehicle v =  VehicleFactory.getVehicle(vehicle);
           if(v!=null){
            v.startEngine();
           }
        }
    }
}
