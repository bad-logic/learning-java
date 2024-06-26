package fundamentals.labs.lab04.lab04_03.employeeinfo;

public class SavingsAccount extends  Account {

    final private double MONTHLY_INTEREST_RATE = 0.25;
    SavingsAccount(Employee emp, double balance) {
        super(emp,balance);
    }

    public AccountType getAcctType() {
        return AccountType.SAVINGS;
    }

    @Override
    public double getBalance() {
        double baseBalance = super.getBalance();
        double interest = (MONTHLY_INTEREST_RATE / 100) * baseBalance;
        return baseBalance + interest;
    }

    @Override
    public String toString() {
        return "Account type: " + AccountType.SAVINGS.getDisplayValue() + "\nCurrent bal: " + this.getBalance();
    }
}
