package fundamentals.labs.lab04.lab04_06.case_03;

import java.util.GregorianCalendar;

public class Person {
    private String name;
    private GregorianCalendar dateOfBirth;
    Person(String name, GregorianCalendar dob) {
        this.name = name;
        this.dateOfBirth = dob;
    }

    public String getName() {
        return name;
    }
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    // OVERRIDING EQUALS METHOD WITH COMPOSITION STRATEGY
    @Override
    public boolean equals(Object a){
        if(a == null) return false;

        if(this.getClass() != a.getClass()) return false;

        Person p = (Person) a;
        return this.name.equals(p.name) && this.dateOfBirth.equals(p.dateOfBirth);
    }
}
