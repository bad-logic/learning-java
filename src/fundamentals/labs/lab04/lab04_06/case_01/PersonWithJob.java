package fundamentals.labs.lab04.lab04_06.case_01;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
    private double salary;
    PersonWithJob(String n, GregorianCalendar dob, double s) {
        super(n, dob);
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }


}