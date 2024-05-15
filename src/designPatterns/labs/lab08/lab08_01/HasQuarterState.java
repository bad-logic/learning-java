package designPatterns.labs.lab08.lab08_01;

import java.util.Random;

public class HasQuarterState implements State{
    Random randomWinner = new Random(System.currentTimeMillis());

    /**
     *
     */
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("You can't insert another quarter");
    }

    /**
     *
     */
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    /**
     *
     */
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    /**
     *
     */
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("No gumball dispensed");
    }
}
