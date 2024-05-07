## Inheritance
In Java, there is a class called `Object`. Every class created in Java
(either in the Java libraries, or user-defined) belongs to the inheritance
hierarchy of Object. classes automatically inherits from Object, even though
we do not write syntax that declares this fact.

- Extends keyword is used to inherit from a class.
- syntax: `class A extends B{}`

### Rule for inheritance:
1. IS-A relation: if A is B then A can inherit from B
2. LSP Rule: liskov substitution principle states that if A extends from B, 
    then instance of A can be used wherever instance of B is expected without breaking any code.

> All (instance + static) members except private members of parents are inherited in child class

> In inheritance if super() is not called inside child constructor, java adds this call as the fist statement
> in the constructor of the child class
```java
class Parent{
    private String id;
    protected double salary;
    public double raisePercentage;

    public static String publicVariable = "publicVariable";
    protected static String protectedVariable = "protectedVariable";
    private static String privateVariable = "privateVariable";

    private static String getPrivateVariable(){
        return Parent.privateVariable;
    }

    public static String getPublicVariable(){
        return Parent.publicVariable;
    }

    protected static String getProtectedVariable(){
        return Parent.protectedVariable;
    }

    Parent(String id, double salary, double raise){
        this.id = id;
        this.salary = salary;
        this.raisePercentage = raise;
    }

    private double getRaisedAmount(){
        return ((this.raisePercentage * this.salary) / 100);
    }

    public double getRaisedSalary(){
        return this.salary + this.getRaisedAmount();
    }

    protected String getId(){
        return this.id;
    }
}

public class Child extends Parent{
    Child(String id, double salary, double raise){
        super(id,salary,raise);
    }

    public void display(){
        System.out.println("child:display");
    }


    public static void main(String[] args){
        Child c = new Child("101",4560.66,12.24);
        System.out.println(c.getRaisedAmount()); // not accessible private to parent not inherited
        System.out.println(c.id); //  not accessible private member not inherited

        System.out.println(c.getId()); // accessible protected member
        System.out.println(c.getRaisedSalary());// accessible public method inherited
        System.out.println(c.salary); // accessible protected member inherited
        System.out.println(c.raisePercentage); // accessible public member inherited


        System.out.println(Child.privateVariable); // not accessible
        System.out.println(Child.protectedVariable); // protected inherited
        System.out.println(Child.publicVariable); // public inherited

        System.out.println(Child.getPrivateVariable()); // not accessible
        System.out.println(Child.getProtectedVariable()); // protected inherited
        System.out.println(Child.getPublicVariable()); // public inherited

    }
}
```

### upcasting and down casting

```java

    Parent p = new Child("111",234.34,23.3); // upcasting
    Child ch = (Child) p; //  down casting
    ch.display(); // no issue

    Parent p1 = new Parent("131",214.34,3.3);
    Child ch1 = (Child) p1; // illegal down casting
    ch1.display(); // no error in compile time, only error in runtime

```

### Advantages of Inheritance
- Reduces code redundancy
- Sub classes are smaller
- can reuse and extend already tested code
- can derive sub classes from already existing classes even though we do not own the source code