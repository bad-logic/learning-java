package fundamentals.labs.lab04.lab04_06.case_03;

import java.util.GregorianCalendar;

public class PersonWithJob {
    private Person person;
    private double salary;

    PersonWithJob(String n, GregorianCalendar dob, double s) {
        this.person = new Person(n,dob);
        this.salary = s;
    }

    public String getName() {
        return this.person.getName();
    }
    public GregorianCalendar getDateOfBirth() {
        return this.person.getDateOfBirth();
    }

    public double getSalary() {
        return this.salary;
    }

    // OVERRIDING EQUALS METHOD WITH COMPOSITION STRATEGY
    @Override
    public boolean equals(Object a){
        if(a == null) return false;

        if(this.getClass() != a.getClass()) return false;

        PersonWithJob p = (PersonWithJob) a;
        return this.person.getName().equals(p.person.getName()) &&
                this.person.getDateOfBirth().equals(p.person.getDateOfBirth()) &&
                this.salary == p.salary;
    }
}