package designPatterns.labs.lab08.lab08_02;

public class ThirdGear implements Gear{

    Car car;

    ThirdGear(Car car){
        this.car = car;
    }

    /**
     * @return
     */
    @Override
    public String getGearValue() {
        return String.valueOf(3);
    }

    /**
     *
     */
    @Override
    public void changeGear(int speed) {
        if(speed > 30){
            this.car.getFourthGear().changeGear(speed);
        }else if(speed < 10){
            this.car.getSecondGear().changeGear(speed);
        }else{
            this.car.setGear(this.car.getThirdGear());
        }
    }
}
