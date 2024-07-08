## Overriding instance methods and Hiding Class ( Static ) Methods

- During inheritance if the child instance method has same signature as the parent class instance method then
  that method in child class is called `overriden method and the process is known as overriding`.
- During inheritance if the child static method has same signature as the static method in parent class, then
  the parent static method is `hidden in child class and the process is known as hiding`.
- Methods marked with `final` specifier cannot be overridden or hidden in child class
- If you declare a same static or instance members in a child class, static methods, static fields, instance fields
  are hidden whereas instance methods are overridden.
- In such scenarios keyword `super` can be used to reference the Immediate parent class members.

```java
class Parent{
    int premium = 500_000;
    static int gold = 55;

    static void sayHello(){
        System.out.println("Hello, from parent class");
    }

    public int getPremium(){
        return this.premium;
    }
}

public class Test extends Parent {
    int premium = 2000; // overrides Parent premium
    static int gold = 56; // hides Parent gold

    static void sayHello(){ // hides Parent sayHello
        System.out.println("Hello, From Test");
    }
    public int getPremium(){ // overrides Parent getPremium
        return this.premium + 1;
    }

    public static void main(String[] args){

        System.out.println(new Test().getPremium());
        System.out.println(Test.gold);
        sayHello();
    }
}

```

### final keyword 
- It restricts the child class from hiding or overriding the static and instance methods.

```java

class Parent{
    final int premium = 500_000;
    final static int gold = 55;

    final static void sayHello(){
        System.out.println("Hello, from parent class");
    }

    final public int getPremium(){
        return this.premium;
    }
}
public class Test extends Parent {
    int premium = 2000; // overrides Parent premium
    static int gold = 56; // hides Parent gold

    static void sayHello(){ // Error: cannot hide Parent sayHello because it is final
        System.out.println("Hello, From Test");
    }
    public int getPremium(){ // Error: cannot override Parent getPremium because it is final
        return this.premium + 1;
    }

    public static void main(String[] args){
        System.out.println(new Test().getPremium());
        System.out.println(Test.gold);
        sayHello();
    }
}

```
### Overriding methods in child class
- To override methods in child classes the access modifier must be stronger or same.
- access modifier strength: `public > protected > default > private`.

```java
class Top{
    // default package level access modifier
    void sayHello(){
        System.out.println("Parent:hello");
    }
}

class Middle extends Top{
    // overriding parent default sayHello with public
    public void sayHello(){
        System.out.println("Middle:hello");
    }
}

class Bottom extends Top{
    // overriding parent default sayHello with protected
    protected void sayHello(){
        System.out.println("Bottom:hello");
    }
}

public class RockBottom extends Top{
    // cannot override parent default sayHello with private
    // error: attempting to assign weaker access privileges
    private void sayHello(){
        System.out.println("Child1:hello");
    }

    public static void main(String[] args){
        new Middle().sayHello();
        new Bottom().sayHello();
        new RockBottom().sayHello();
    }
}
```

## Dynamic Method Dispatch
> dynamic method dispatch is a mechanism by which a call to an overrriden method is resolved at run time
> rather than on compile time. this is how java implements run time polymorphism.


> A super class reference variable can refer to a subclass object <i><b>Parent p = new Child()</b></i>. java uses this
> fact to resolve calls to overridden methods at run time. when an overridden method is called through a superclass
> reference, java determines which version of that method to execute based upon the type of the object being referred to
> at the time the call occurs. Thus, this determination is made at run time. when different types of objects are referred
> to, different versions of an overridden method will be called. In other words, it is the type of the object being 
> referred to ( not the type of the reference variable) that determines which version of an overridden method will be
> executed. Therefore if a super class contains a method that is overridden by a subclass, then when different types
> of objects are referred to through a superclass reference variable, different versions of the method are executed.

```java

class A{
    void callme(){
      System.out.println("A's callme method");
    }
}

class B extends A{
    void callme(){
      System.out.println("B's callme method");
    }
}

class C extends A{
  void callme(){
    System.out.println("C's callme method");
  }
}

class Main{
    public static void main(String[] args){
        A a = new A(); // object of type A
        B b = new B(); // object of type B
        C c = new C(); // object of type C
      
      A r; // reference of type A
      
      r = a; // r refers to object of type A
      r.callme(); // calls A's callme method
      
      r = b; // r refers to object of type B
      r.callme(); // calls B's callme method
      
      r = c; // r refers to object of type C
      r.callme(); // calls C's callme method
    }
}
```