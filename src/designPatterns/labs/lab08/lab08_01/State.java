package designPatterns.labs.lab08.lab08_01;

public interface State {
    void insertQuarter(GumballMachine gumballMachine);
    void ejectQuarter(GumballMachine gumballMachine);
    void turnCrank(GumballMachine gumballMachine);
    void dispense(GumballMachine gumballMachine);
    default void refill(GumballMachine gumballMachine){}
}
