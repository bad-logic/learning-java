package fundamentals.labs.lab04.lab04_06.case_01;

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

    // OVERRIDING EQUALS METHOD WITH INSTANCE OF STRATEGY
    @Override
    public boolean equals(Object a){
        // null is not an instance of Person
        // so checking null is redundant
        if(!(a instanceof Person)) return false;
        Person p = (Person) a;
        return this.name.equals(p.name) && this.dateOfBirth.equals(p.dateOfBirth);
    }
}
