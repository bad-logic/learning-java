package designPatterns.labs.lab08.lab08_02;

public class FifthGear implements Gear{

    Car car;

    FifthGear(Car car){
        this.car = car;
    }

    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return String.valueOf(5);
    }

    /**
     *
     */
    @Override
    public void changeGear(int speed) {
        if(speed < 55){
            this.car.getFourthGear().changeGear(speed);
        }else{
            this.car.setGear(this.car.getFifthGear());
        }
    }
}
