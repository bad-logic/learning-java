package designPatterns.labs.lab08.lab08_01;

public class WinnerState implements State{

    /**
     *
     */
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Sorry!!!");
    }

    /**
     *
     */
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Sorry!!!");
    }

    /**
     *
     */
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("Sorry!!!");
    }

    /**
     *
     */
    @Override
    public void dispense(GumballMachine gumballMachine) {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
