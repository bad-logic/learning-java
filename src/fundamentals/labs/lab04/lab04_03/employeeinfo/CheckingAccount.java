package fundamentals.labs.lab04.lab04_03.employeeinfo;

public class CheckingAccount extends Account{
    private final int monthlyServiceCharge = 5;

    CheckingAccount(Employee emp, double balance) {
       super(emp,balance);
    }

    public AccountType getAcctType() {
        return AccountType.CHECKING;
    }

    @Override
    public double getBalance() {
        double baseBalance = super.getBalance();
        return baseBalance - monthlyServiceCharge;
    }

    @Override
    public String toString() {
        return "Account type: " + AccountType.CHECKING.getDisplayValue() + "\nCurrent bal: " + this.getBalance();
    }
}
