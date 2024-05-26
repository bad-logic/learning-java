package designPatterns.labs.lab08.lab08_02;

public class FourthGear implements Gear{

    Car car;

    FourthGear(Car car){
        this.car = car;
    }

    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return String.valueOf(4);
    }

    /**
     *
     */
    @Override
    public void changeGear(int speed) {
        if(speed > 55){
            this.car.getFifthGear().changeGear(speed);
        }else if(speed < 30){
            this.car.getThirdGear().changeGear(speed);
        }else{
            this.car.setGear(this.car.getFourthGear());
        }
    }
}
