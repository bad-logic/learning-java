package fundamentals.labs.lab03.lab03_02.employeeinfo;

import java.time.LocalDate;

public class Employee {

    private Account savingsAcct;
    private Account checkingAcct;
    private Account retirementAcct;
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
        this.checkingAcct = new Account(this,AccountType.CHECKING,startAmount);
    }

    public void createNewSavings(double startAmount) {
        this.savingsAcct = new Account(this,AccountType.SAVINGS,startAmount);
    }

    public void createNewRetirement(double startAmount) {
        this.retirementAcct = new Account(this,AccountType.RETIREMENT,startAmount);
    }

    public String getFormattedAcctInfo() {
        String output = "";
        if(this.checkingAcct != null){
            output += this.checkingAcct.toString() + "\n";
        }

        if(this.savingsAcct != null){
            output += this.savingsAcct.toString() + "\n";
        }

        if(this.retirementAcct != null){
            output += this.retirementAcct.toString() + "\n";
        }

        return  output;
    }
    public void deposit(AccountType acctType, double amt){
        switch (acctType){
            case AccountType.CHECKING:
                this.checkingAcct.makeDeposit(amt);
                break;
            case AccountType.SAVINGS:
                this.savingsAcct.makeDeposit(amt);
                break;
            case AccountType.RETIREMENT:
                this.retirementAcct.makeDeposit(amt);
                break;
            default:
                // do nothing
        }
    }
    public boolean withdraw(AccountType acctType, double amt){
        boolean success = false;
        switch (acctType){
            case AccountType.CHECKING:
                success = this.checkingAcct.makeWithdrawal(amt);
                break;
            case AccountType.SAVINGS:
                success = this.savingsAcct.makeWithdrawal(amt);
                break;
            case AccountType.RETIREMENT:
                success = this.retirementAcct.makeWithdrawal(amt);
                break;
            default:
                // do nothing
        }
        return success;
    }

}
