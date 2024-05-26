package designPatterns.labs.lab08.lab08_02;

public class FirstGear implements Gear{

    Car car;

    FirstGear(Car car){
        this.car = car;
    }

    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return String.valueOf(1);
    }

    /**
     * @return
     */
    @Override
    public void changeGear(int speed) {
        if(speed > 5){
            this.car.getSecondGear().changeGear(speed);
        }else if(speed < 1){
            this.car.getParking().changeGear(speed);
        }else{
            this.car.setGear(this.car.getFirstGear());
        }
    }
}
