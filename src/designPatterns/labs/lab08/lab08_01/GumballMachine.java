package designPatterns.labs.lab08.lab08_01;

public class GumballMachine {
    State noQuarterState, hasQuarterState,soldOutState,soldState,winnerState;

    int count = 0;
    State state;

    GumballMachine(int gumballsCount){
        this.count = gumballsCount;
        noQuarterState = new NoQuarterState();
        hasQuarterState = new HasQuarterState();
        soldOutState = new SoldOutState();
        soldState = new SoldState();
        winnerState = new WinnerState();

        if (gumballsCount > 0) {
            this.state = noQuarterState;
        } else {
            this.state = soldOutState;
        }
    }

    public State getNoQuarterState() {
        return this.noQuarterState;
    }

    public State getHasQuarterState() {
        return this.hasQuarterState;
    }

    public State getSoldOutState() {
        return this.soldOutState;
    }

    public State getSoldState() {
        return this.soldState;
    }

    public State getWinnerState() {
        return this.winnerState;
    }


    public int getCount() {
        return this.count;
    }

    public void insertQuarter() {
        state.insertQuarter(this);
    }

    public void ejectQuarter() {
        state.ejectQuarter(this);
    }

    public void turnCrank() {
        state.turnCrank(this);
        state.dispense(this);
    }

    void setState(State state){
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        state.refill(this);
    }

    public String toString(){
        return "Gumball \n Inventory: "+this.count + " gumballs \n";
    }
}
