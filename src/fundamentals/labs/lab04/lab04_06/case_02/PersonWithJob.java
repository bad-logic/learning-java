package fundamentals.labs.lab04.lab04_06.case_02;

import java.util.GregorianCalendar;

final public class PersonWithJob extends Person {
    private double salary;
    PersonWithJob(String n, GregorianCalendar dob, double s) {
        super(n, dob);
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }

    // OVERRIDING EQUALS METHOD WITH SAME CLASS STRATEGY
    @Override
    public boolean equals(Object a){
        if(a == null) return false;

        if(this.getClass() != a.getClass()) return false;

        PersonWithJob p = (PersonWithJob) a;
        return this.getName().equals(p.getName()) &&
                this.getDateOfBirth().equals(p.getDateOfBirth()) &&
                this.salary == p.salary;
    }
}