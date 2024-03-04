package fundamentals.labs.lab03_01;

class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private AccountType acctType;
    private Employee employee;

    Account(Employee emp, AccountType acctType, double balance) {
        this.employee = emp;
        this.acctType = acctType;
        this.balance = balance;
    }

    Account(Employee emp, AccountType acctType) {
        this(emp, acctType, DEFAULT_BALANCE);
    }

    public String toString() {
        return "type = " + acctType + ", balance = " + balance;
    }

    public void makeDeposit(double deposit) {
        this.balance += deposit;
    }

    public boolean makeWithdrawal(double amount) {
        if(amount > this.balance){
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public AccountType getAccountType(){
        return this.acctType;
    }
    public double getBalance(){
        return this.balance;
    }
}
