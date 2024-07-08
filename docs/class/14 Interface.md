## Interface

- An interface in java is like an abstract class with the following:
    1. no instance variables ( other than variables declared final ).
    2. declared with interface keyword.
    3. interface can extend/inherit multiple interfaces.
    4. class implementing interface should either implement the methods or declare it as abstract.

### interface vs concrete class vs abstract class

| identity | concrete class | abstract class | interface                    | 
| -------- | -------------- | -------------- |------------------------------|
| constant ( public, final, static ) | yes | yes| yes                          |
| constructor | yes | yes | no                           |
|instatiation | yes | no | no                           |
| instance members | yes | yes | (Pre / Post ) java 8 depends |

### interface Comparison pre and post java 8.
>Pre Java 8:<br>
  • no private or protected members.<br>
  • no instance variables, all variables are public static final implicitly (essentially constants).<br>
  • no instance methods.<br>
  • all methods are public abstract implicitly.<br>
  • no static methods.<br>

>Java 8 & 8+:<br>
  • no private or protected members.<br>
  • no instance variables, all variables are public static final implicitly (essentially constants).<br>
  • can have default methods ( instance methods ), inherited by implementing class.<br>
  • all methods are public abstract implicitly.<br>
  • can have implemented static methods.<br>

>So, when referring to methods within an interface:<br>
    • <b><i>Abstract methods</i></b> are methods without a body that must be implemented by classes.<br>
    • <b><i>Default methods</i></b> are methods with a body that can be optionally overridden.<br>
    • <b><i>Static methods</i></b> are methods that belong to the interface itself and cannot be overridden or accessed via class instances.<br>


```java

interface Test1{
    public static final int hello = 0;
    public abstract void implementMe();
    public static void  hello(){
        System.out.println("hello");
    }
    
    default public void sayHello(){
      System.out.println("hello");
    }
}

// OR 

interface Test1{
  int hello = 0;
  void implementMe();
  static void  hello(){
    System.out.println("hello");
  }

  default void sayHello(){
    System.out.println("hello");
  }
}

```

### Type of interfaces
 - functional Interface : interface with just one abstract methods, methods matching the signature from Object class does not count.
  ```java
@FunctionalInterface
public interface Test1{
    void implementMe();
    boolean equals(Object object);
}

@FunctionalInterface
public interface Test2{
  void implementMe();
}
```
 - Tag Interface ( cloneable, serializable, RandomAccess )

