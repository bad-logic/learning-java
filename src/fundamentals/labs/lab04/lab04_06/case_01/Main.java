package fundamentals.labs.lab04.lab04_06.case_01;

import java.util.GregorianCalendar;

// OVERRIDING EQUALS METHOD WITH INSTANCE OF STRATEGY
public class Main {

    public static void main(String[] args){
        Person p1 = new Person("Greg",new GregorianCalendar(1991,1,12));
        Person p2 = new Person("Greg",new GregorianCalendar(1991,1,12));
        Person p3 = new Person("Gregory",new GregorianCalendar(1991,1,12));
        Person p4 = new Person("Greg",new GregorianCalendar(1991,1,13));

        System.out.println(p1.equals(p2)); // true
        System.out.println(p2.equals(p1)); // true
        System.out.println(p1.equals(p3)); // false
        System.out.println(p3.equals(p4)); // false

        PersonWithJob p5 = new PersonWithJob("Greg",new GregorianCalendar(1991,1,12),234234.23);
        PersonWithJob p6 = new PersonWithJob("Greg",new GregorianCalendar(1991,1,12),234234.23);
        PersonWithJob p7 = new PersonWithJob("Gregory",new GregorianCalendar(1991,1,12),234234.23);
        PersonWithJob p8 = new PersonWithJob("Greg",new GregorianCalendar(1991,1,13),234234.23);
        PersonWithJob p9 = new PersonWithJob("Greg",new GregorianCalendar(1991,1,13),234234.26);

        System.out.println(p5.equals(p6)); // true
        System.out.println(p6.equals(p5)); // true
        System.out.println(p5.equals(p7)); // false
        System.out.println(p5.equals(p8)); // false
        System.out.println(p5.equals(p9)); // false

        System.out.println(p1.equals(p5)); // true
        System.out.println(p5.equals(p1)); //  true

    }
}
