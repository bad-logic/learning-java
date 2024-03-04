package fundamentals.labs.lab04.lab04_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Professor prof1 = new Professor("Rob",23456.98,2020,3,23);
        Professor prof2 = new Professor("Jeff",43444,2010,1,12);
        Professor prof3 = new Professor("Jenny",45000,2000,11,25);

        prof1.setNumberOfPublications(10);
        prof2.setNumberOfPublications(10);
        prof3.setNumberOfPublications(10);

        Secretary sec1 = new Secretary("Jasmine",23000,2018,11,23);
        Secretary sec2 = new Secretary("Jessy",22000,202,10,15);
        sec1.setOverTimeHours(200);
        sec2.setOverTimeHours(200);

        DeptEmployee[] employees = new DeptEmployee[5];
        employees[0] = prof1;
        employees[1] = prof2;
        employees[2] = prof3;
        employees[3] = sec1;
        employees[4] = sec2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to see the sum of all salaries in the department? (y/n) ");
        String answer = sc.next();
        if(answer.equalsIgnoreCase("y")){
            double sum = 0.0;
            for(DeptEmployee emp: employees){
                sum += emp.computeSalary();
            }

            System.out.println("The total salaries is " + sum);
        }
    }

}
