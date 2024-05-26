package designPatterns.labs.lab08.lab08_02;

public class Parking implements Gear{

    Car car;

    Parking(Car car){
        this.car = car;
    }
    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return "Park";
    }

    /**
     * @return
     */
    @Override
    public void changeGear(int speed) {
        if(speed > 0){
            this.car.getFirstGear().changeGear(speed);
        }else{
            this.car.setGear(this.car.getParking());
        }
    }
}
