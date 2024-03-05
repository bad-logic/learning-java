package fundamentals.labs.lab04.lab04_03.employeeinfo;

public enum AccountType {
    CHECKING("checking"),
    SAVINGS("savings"),
    RETIREMENT("retirement");

    private final String displayValue;
    private AccountType(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return this.displayValue;
    }
}
