package designPatterns.labs.lab08.lab08_01;

public class SoldState implements State{

    /**
     *
     */
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    /**
     *
     */
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Sorry, you already turned the crank");
    }

    /**
     *
     */
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    /**
     *
     */
    @Override
    public void dispense(GumballMachine gumballMachine) {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
