package fundamentals.labs.lab04.lab04_03.employeeinfo;

public class RetirementAccount extends Account {

    final private double withdrawalPenaltyRate = 2;
    public RetirementAccount(Employee emp, double balance) {
        super(emp,balance);
    }

    public AccountType getAcctType() {
        return AccountType.RETIREMENT;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        if(amount < 1) return false;
        double penalty = ( withdrawalPenaltyRate / 100 ) * amount;
        return super.makeWithdrawal(amount + penalty);
    }

    @Override
    public String toString() {
        return "Account type: " + AccountType.RETIREMENT.getDisplayValue() + "\nCurrent bal: " + this.getBalance();
    }
}
