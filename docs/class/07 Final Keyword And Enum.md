## Constants And Enum


### Final Keyword
- prevents its contents from being modified, making it essentially a constant.
- `private final String name;` : name field can never be changed.
- `public static final int TAX_RATE;` : TAX_RATE is considered to be a constant.
- `public final class Greet{}`: Class cannot be inherited.
- `public final void sayHello(){}`: Instance method cannot be overridden in subclass.
- `public final static void sayHello(){}`: Static method cannot be hidden in subclass.

> combination of final and abstract keyword is invalid. since abstract implies the method or class is incomplete,
> and we are supposed to provide the implementation in the subclass but final does not allow inheriting class 
> or overriding a method.

A more reliable way to store constants is to use an enumerated type (also called
an enumeration type). An enumerated type is a class all of whose possible
instances are explicitly enumerated during initialization.


```java

public enum Size { 
    SMALL, MEDIUM, LARGE
};


```
