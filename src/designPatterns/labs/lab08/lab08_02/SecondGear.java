package designPatterns.labs.lab08.lab08_02;

public class SecondGear implements Gear{

    Car car;

    SecondGear(Car car){
        this.car = car;
    }

    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return String.valueOf(2);
    }

    /**
     *
     */
    @Override
    public void changeGear(int speed) {
        if(speed > 10){
            this.car.getThirdGear().changeGear(speed);
        }else if(speed < 5){
            this.car.getFirstGear().changeGear(speed);
        }else{
            this.car.setGear(this.car.getSecondGear());
        }
    }
}
