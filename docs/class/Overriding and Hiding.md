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