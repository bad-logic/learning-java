package fundamentals.labs.lab04.lab04_03.employeeinfo;

public class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private Employee employee;

    Account(Employee emp, double balance) {
        this.employee = emp;
        this.balance = balance;
    }

    Account(Employee emp) {
        this(emp, DEFAULT_BALANCE);
    }

    public void makeDeposit(double deposit) {
        this.balance += deposit;
    }

    public boolean makeWithdrawal(double amount) {
        if(amount > this.balance){
            System.out.println("Insufficient Funds");
            return false;
        }
        this.balance -= amount;
        return true;
    }
    public double getBalance(){
        return this.balance;
    }
}
