package fundamentals.labs.lab04.lab04_03.employeeinfo;

public class RetirementAccount extends Account {

    final private double WITHDRAWAL_PENALTY_PERCENT = 2.0;
    public RetirementAccount(Employee emp, double balance) {
        super(emp,balance);
    }

    public AccountType getAcctType() {
        return AccountType.RETIREMENT;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        if(amount < 1) return false;
        double bal = super.getBalance();

        double penalty = ( WITHDRAWAL_PENALTY_PERCENT / 100) * bal;

        return super.makeWithdrawal(amount + penalty);
    }

    @Override
    public String toString() {
        return "Account type: " + AccountType.RETIREMENT.getDisplayValue() + "\nCurrent bal: " + this.getBalance();
    }
}
