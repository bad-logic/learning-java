## Interface

- An interface in java is like an abstract class with the following:
    1. no instance variables ( other than variables declared final ).
    2. declared with interface keyword.
    3. interface can extend/inherit multiple interfaces.
    4. class implementing interface should either implement the methods or declare it as abstract.
    5. declared either public or default package level access.

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
  • can have default methods ( instance methods or extension method ), inherited by implementing class.<br>
  • all unimplemented methods are public abstract implicitly.<br>
  • can have implemented static methods.<br>
  • unlike static methods in classes, static methods are not inherited by the extending interface or the implementing class<br>


>Beginning with JDK 9 we can have private implemented methods in the interface, which is accessible within 
> the interface only. private methods can be called only by the default method or another private method of the same interface.

>So, when referring to methods within an interface:<br>
    • <b><i>Abstract methods</i></b> are methods without a body that must be implemented by classes.<br>
    • <b><i>Default methods</i></b> are methods with a body that can be optionally overridden.<br>
    • <b><i>Static methods</i></b> are methods that belong to the interface itself and cannot be overridden or accessed via class instances.<br>
    • <b><i>Private methods</i></b> are methods that belong to the interface itself, and only accessible via the default interface methods.<br>

>variables defined inside the interface are automatically imported as constants in the implementing class.


```java

interface Test1{
    public static final int hello = 0;
    public abstract void implementMe();
    
    private void say(String msg){
      System.out.println(msg);
    }
  
    default public void sayHello(){
      this.say("Hello");
    }
    
    public static void  hello(){
        System.out.println("hello");
    }

}

// OR 

interface Test1{
  int hello = 0;
  void implementMe();

  private void say(String msg){
    System.out.println(msg);
  }

  default void sayHello(){
    this.say("Hello");
  }
  
  static void  hello(){
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

- Member or Nested interface: An interface can be declared a member of a class or another interface.
    A nested interface can be declared as public, protected or private. this differs from the top level
    interface, which must be declared either as public or default package level access.

```java

class A {
    public interface INested {
        boolean isEven(int x);
    }
}

class B implements A.INested{
    public boolean isEven(int x){
        return x % 2 == 0;
    }
}

```

- Marker interface
- Tag Interface ( cloneable, serializable, RandomAccess )

