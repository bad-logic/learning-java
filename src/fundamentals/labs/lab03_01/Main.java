package fundamentals.labs.lab03_01;

public class Main {

    public static void main(String[] args){
        Employee employee = new Employee("John","Johnny",23454.98,2024,2,24);
        Account checkingAccount = new Account(employee,AccountType.CHECKING,300);
        Account savingsAccount = new Account(employee,AccountType.SAVINGS,300);
        Account retirementAccount = new Account(employee,AccountType.RETIREMENT,300);

        System.out.println(checkingAccount);
        System.out.println(savingsAccount);
        System.out.println(retirementAccount);

    }
}
