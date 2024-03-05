package fundamentals.labs.lab04.lab04_03.employeeinfo;

import java.time.LocalDate;

import fundamentals.labs.lab04.lab04_03.AccountList;
import fundamentals.labs.lab04.lab04_03.MyStringList;

public class Employee {
    private AccountList accounts = new AccountList();
    private MyStringList accountNames = new MyStringList();

    private String name;
    private LocalDate hireDate;

    /**
     * Initializes an Employee Object
     *
     * @param name The name of the employee
     * @param yearOfHire  The year of the date. Should be in the range -999999 to 999999.
     * @param monthOfHire The month of the date. Should be in the range 1 to 12.
     * @param dayOfHire   The day of the date. Should be in the range 1 to 31.
     */
    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire,monthOfHire,dayOfHire);
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getHireDate(){
        return this.hireDate;
    }

    public void createNewChecking(double startAmount) {
        this.accountNames.add(AccountType.CHECKING.getDisplayValue() );
        this.accounts.add( new CheckingAccount(this,startAmount));
    }

    public void createNewSavings(double startAmount) {
        this.accountNames.add(AccountType.SAVINGS.getDisplayValue() );
        this.accounts.add( new SavingsAccount(this,startAmount));
    }

    public void createNewRetirement(double startAmount) {
        this.accountNames.add(AccountType.RETIREMENT.getDisplayValue() );
        this.accounts.add( new RetirementAccount(this,startAmount));
    }

    public String getFormattedAcctInfo() {
        String output = "";
        for(Account acc: this.accounts.getAccounts()){
            output += acc.toString() + "\n";
        }
        return  output;
    }
    public void deposit(int acctIndex, double amt){
        Account acc = this.accounts.get(acctIndex);
        if(acc == null){
            System.out.println("This account does not exists");
            return;
        }
        acc.makeDeposit(amt);
    }

    public boolean withdraw(int acctIndex, double amt){
        Account acc = this.accounts.get(acctIndex);
        if(acc == null){
            System.out.println("This account does not exists");
            return false;
        }
        return acc.makeWithdrawal(amt);
    }

    public String[] getNamesOfAccounts(){
        return this.accountNames.getStringLists();
    }

}
