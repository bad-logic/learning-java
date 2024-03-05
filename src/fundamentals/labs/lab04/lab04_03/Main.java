package fundamentals.labs.lab04.lab04_03;

import java.util.Scanner;

import fundamentals.labs.lab04.lab04_03.employeeinfo.Employee;


public class Main {

    static Employee[] emps = new Employee[3];
    static int employeeId;
    static int accountId;
    static Scanner sc = new Scanner(System.in);
    private static String getFormattedAccountInfo(){
        String output = "";
        for(Employee emp:emps){
            output += "ACCOUNT INFO FOR " + emp.getName()+":\n\n" + emp.getFormattedAcctInfo() + "\n";
        }
        return output;
    }

    private static void prompt(){
        System.out.print("0. Jim Daley\n" +
                "1. Bob Reuben\n" +
                "2. Susan Randolph\n" +
                "Select an employee: (type a number) ");
        employeeId = sc.nextInt();

        if(!(employeeId >= 0 && employeeId <=2)){
            System.out.println("Employee out of range");
            System.exit(0);
        }
        System.out.print("0. checking\n" +
                "1. savings\n" +
                "2. retirement\n" +
                "Select an account: (type a number) ");
        accountId = sc.nextInt();

        if(!(accountId >= 0 && accountId <=2)){
            System.out.println("Employee out of range");
            System.exit(0);
        }

    }

    private static void handleReports(){
        System.out.println(Main.getFormattedAccountInfo());
    }

    private static void handleWithdrawals(){
        prompt();

        System.out.print("WithDrawal Amount: ");
        double amount = sc.nextDouble();
        if(amount<1){
            System.out.println("Cannot withdraw amount: " + amount);
            return;
        }

        Employee employee = emps[employeeId];

        if(employee.withdraw(accountId,amount)){
            System.out.println("$" + amount + " has been withdrawn from the\n" + employee.getNamesOfAccounts()[accountId] +
                    " account of " + employee.getName());
        }
    }

    private static void handleDeposit(){
        prompt();

        System.out.print("Deposit Amount: ");
        double amount = sc.nextDouble();
        if(amount<1){
            System.out.println("Cannot deposit amount: " + amount);
            return;
        }

        Employee employee = emps[employeeId];
        employee.deposit(accountId,amount);
        System.out.println("$" + amount + " has been deposited in the\n" + employee.getNamesOfAccounts()[accountId] +
                    " account of " + employee.getName());

    }

    public static void main(String[] args){
        // Initialization

        emps[0] = new Employee("Jim Daley", 2000, 9, 4);
        emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
        emps[2] = new Employee("Susan Randolph", 1997, 2,13);

        emps[0].createNewChecking(10500);
        emps[0].createNewSavings(1000);
        emps[0].createNewRetirement(9300);
        emps[1].createNewChecking(34000);
        emps[1].createNewSavings(27000);
        emps[2].createNewChecking(10038);
        emps[2].createNewSavings(12600);
        emps[2].createNewRetirement(9000);

        // prompt
        Scanner sc = new Scanner(System.in);
        System.out.print("A. See a report of all accounts.\n" +
                "B. Make a deposit.\n" +
                "C. Make a withdrawal.\n" +
                "Make a selection (A/B/C): ");
        String answer = sc.next();

        switch (answer.toUpperCase()){
            case "A":
                Main.handleReports();
                break;
            case "B":
                Main.handleDeposit();
                break;
            case "C":
                Main.handleWithdrawals();
                break;
            default:
                // do nothing
                break;
        }
    }
}
