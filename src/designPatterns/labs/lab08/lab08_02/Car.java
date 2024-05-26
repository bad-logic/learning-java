package designPatterns.labs.lab08.lab08_02;


public class Car{
    Gear firstGear;
    Gear secondGear;
    Gear thirdGear;
    Gear fourthGear;
    Gear fifthGear;
    Gear parking;

    Gear gear;

    Car(){
        firstGear = new FirstGear(this);
        secondGear = new SecondGear(this);
        thirdGear = new ThirdGear(this);
        fourthGear = new FourthGear(this);
        fifthGear = new FifthGear(this);
        parking = new Parking(this);
        gear = parking;
    }

    public void changeSpeed(int speed){
        this.gear.changeGear(speed);
    }

    public void setGear(Gear gear){
        this.gear = gear;
    }

    public Gear getFirstGear() {
        return this.firstGear;
    }

    public Gear getSecondGear() {
        return this.secondGear;
    }

    public Gear getThirdGear() {
        return this.thirdGear;
    }

    public Gear getFourthGear() {
        return this.fourthGear;
    }

    public Gear getFifthGear() {
        return this.fifthGear;
    }

    public Gear getParking() {
        return this.parking;
    }

    public String getGearValue(){
        return this.gear.getGearValue();
    }

}
