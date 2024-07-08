## Overriding equals Method

- We can compare the primitives using the '==' operator. 
-  For comparing objects, we should use equalsTo method. 
- The default implementation of equalsTo method checks for the memory references of the objects. so, returns true
    only if both objects are same.
- Thus we need to override the default implementation with our own.

### Different ways of overriding equalsTo method in inherited classes.
- instance of strategy
- getClass strategy
- composition ( has-a ) strategy

let's assume we have a person class 
```java 
class Person{
    private String name;
    Person(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    
    // OVERRIDING USING INSTANCE OF STRATEGY
    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(!(aPerson instanceof Person)) return false;
        Person p = (Person)aPerson;
        boolean isEqual = this.name.equals(p.name);
        return isEqual;
    }
}

```

so far so good, now if we need to inherit this class in another class like so...

```java

class PersonWithJob extends Person {
    private double salary;
    PersonWithJob(String n, double s) {
        super(n);
        salary = s;
    }
}

```

here the equals method is inherited to the PersonWithJob. and if we try to use compare objects following happens.
```java
public class Demo {

    public static void main(String[] args) {

        PersonWithJob p1 = new PersonWithJob("Ben", 100000);
        PersonWithJob p2 = new PersonWithJob("John", 50000);

        Person p3 = new Person("Ben");
        
        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p1)); // false
        
        System.out.println(p3.equals(p1)); // true
        System.out.println(p1.equals(p3)); // true

    }
}

```
we can see from the above code sample that p1 and p2 comparision results a correct and consistent response.
Also we can observe that the equality check for p1 and p3 returns true since p3, p1 are both instances of Person and have consistent result
on comparing from both sides. If this does not cause any issues with your application then it is okay. but you need to be weary 
about the situation here. This type of overriding is known as <i><b>instance of strategy for overriding equals</b></i> method.

Also lets look at the scenario if this does not work for your application and you need a separate equals method for the subclass.
let's add a separate equals method in PersonWithJob class.

```java

class PersonWithJob extends Person {
    private double salary;

    PersonWithJob(String n, double s) {
        super(n);
        salary = s;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(!(aPerson instanceof PersonWithJob)) return false;
        PersonWithJob p = (PersonWithJob)aPerson;
        boolean isEqual = this.getName().equals(p.getName()) && this.getSalary() == p.getSalary();
        return isEqual;
    }
}


public class Demo {

    public static void main(String[] args){
        PersonWithJob p1 = new PersonWithJob("Ben", 100000);
        PersonWithJob p2 = new PersonWithJob("Ben", 50000);
        Person p3 = new Person("Ben");

        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p1)); // false

        System.out.println(p3.equals(p2)); // true
        System.out.println(p2.equals(p3)); // false
    }
}

```

we can see that in the main method if we compare the p1 and p2 which are of the same class, they work just fine. but when we compare between
the Person and PersonWithJob we get inconsistent result. `p3.equals(p2) == true` and `p2.equals(p3) == false`. The response is not symmetrical.
it violates the contract for quality.

now lets try a different approach
```java

class Person{
    private String name;
    Person(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    // OVERRIDING USING GET CLASS STRATEGY
    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(aPerson.getClass() != this.getClass()) return false;
        Person p = (Person)aPerson;
        boolean isEqual = this.name.equals(p.name);
        return isEqual;
    }
}

class PersonWithJob extends Person {
    private double salary;

    PersonWithJob(String n, double s) {
        super(n);
        salary = s;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(aPerson.getClass() != this.getClass()) return false;
        PersonWithJob p = (PersonWithJob)aPerson;
        boolean isEqual = this.getName().equals(p.getName()) && this.getSalary() == p.getSalary();
        return isEqual;
    }
}

public class Demo {

    public static void main(String[] args){
        PersonWithJob p0 = new PersonWithJob("Ben", 50000);
        PersonWithJob p1 = new PersonWithJob("Ben", 100000);
        PersonWithJob p2 = new PersonWithJob("Ben", 50000);
        Person p3 = new Person("Ben");

        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p1)); // false

        System.out.println(p3.equals(p2)); // false
        System.out.println(p2.equals(p3)); // false

        System.out.println(p0.equals(p2)); // true
        System.out.println(p2.equals(p0)); // true

    }
}


```

This solves the asymmetry problem. now Person can never be equal to PersonWithJob. This type of overriding is known as <b><i>same class strategy for overriding equals</i></b> method.

Now lets look at a scenario where we need to inherit from PersonWithJob class.
```java
class PersonWithJobWithCounter extends PersonWithJob {
    static private int counter;
    PersonWithJobWithCounter(String n, double s){
        super(n, s);
        counter++;
    }
}

public class Demo {

    public static void main(String[] args){
        PersonWithJob p1 = new PersonWithJob("Joe", 50000);
        PersonWithJobWithCounter p2 = new PersonWithJobWithCounter("Joe", 50000);

        System.out.println(p1.equals(p2)); // false

    }
}
```

we can see the PersonWithJobWithCounter just keeps the count of number of objects created. In main method we are basically creating the same object, one with
counter and one without. But the equals check is returning false. this creates a problem. so whenever we are using <b><i>same class strategy</i></b>, we should
declare the subclass as final so that it cannot be inherited by another class causing unexpected results.

What if we do not want to make the PersonWithJob class final. how do we solve this problem of inconsistent equals response. let's look at another strategy
of overriding a equals method called <b><i>composition instead of inheritance strategy</i></b>.

```java

class Person{
    private String name;
    Person(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(aPerson.getClass() != this.getClass()) return false;
        Person p = (Person)aPerson;
        boolean isEqual = this.name.equals(p.name);
        return isEqual;
    }
}

class PersonWithJob {
    private double salary;
    private Person person;

    PersonWithJob(String n, double s) {
        person = new Person(n);
        salary = s;
    }

    public double getSalary(){
        return salary;
    }

    public Person getPerson(){
        return person;
    }

    // OVERRIDING USING COMPOSITION STRATEGY
    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        PersonWithJob p = (PersonWithJob)aPerson;
        boolean isEqual =  this.getPerson().equals(p.getPerson()) && this.getSalary() == p.getSalary();
        return isEqual;
    }
}

class PersonWithJobWithCounter extends PersonWithJob {
    static private int counter;
    PersonWithJobWithCounter(String n, double s){
        super(n, s);
        counter++;
    }
}

public class Demo {

    public static void main(String[] args){
        PersonWithJob p1 = new PersonWithJob("Joe", 50000);
        PersonWithJobWithCounter p2 = new PersonWithJobWithCounter("Joe", 50000);
        PersonWithJobWithCounter p3 = new PersonWithJobWithCounter("Joe", 50000);
        PersonWithJobWithCounter p4 = new PersonWithJobWithCounter("Joe1", 50000);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p2.equals(p1)); // true

        System.out.println(p2.equals(p3)); // true
        System.out.println(p3.equals(p2)); // true

        System.out.println(p3.equals(p4)); // false
        System.out.println(p4.equals(p3)); //false

    }
}


```

### Best Practices for overriding equals method.
1. instance of strategy: if B extends from A and it is acceptable for B to use the same equals method as A.
2. get class strategy: if B extends from A but both require different equals method and B can be made final to prevent unexpected results from equals method.
3. Composition instead of Inheritance: if different equals methods are required but you do not want to make B final for different reasons, go with this strategy.
    this will work as long as inheritance between A and B is not required.