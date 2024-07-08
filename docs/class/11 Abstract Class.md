## Abstract Keyword

- If a class is declared abstract, it cannot be instantiated because it is an incomplete class.
- If a method is declared abstract, it cannot have a body -- it can only be declared.
- If a class has at least one abstract method, the class must be declared abstract.
- A subclass of an abstract class must implement (provide method bodies for) every abstract method in its superclass (or else declare unimplemented methods abstract).
- Abstract classes may include instance variables and other non-abstract (implemented) methods.
- Abstract classes cannot declare abstract constructors or abstract static methods.

```java

abstract class Super{

    public abstract void implementMe();

    // abstract Super(); // Illegal: No abstract constructor

    // public abstract static void callme(); // Illegal: No abstract static method

    public static void sing(){
        System.out.println("hello");
    }
}

public class Child extends Super{

    public void override(){
        System.out.println("hey i am child overload");
    }

    /**
     *
     */
    @Override
    public void implementMe() {
        System.out.println("implemented");

    }

    public static void main(String[] args){
        // Super s1 = new Super(); // Error: Super' is abstract; cannot be instantiated
            Super t = new Child();
            t.implementMe();
    }
}

```