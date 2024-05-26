package designPatterns.labs.lab08.lab08_01;

public class NoQuarterState implements State{

    /**
     *
     */
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    /**
     *
     */
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("You haven't inserted a quarter");
    }

    /**
     *
     */
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You turned, but there's no quarter");
    }

    /**
     *
     */
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("You need to pay first");
    }
}
