## Constants And Enum


### Final Keyword
- `private final String name;` : name field can never be changed.
- `public static final int TAX_RATE;` : TAX_RATE is considered to be a constant.
- `public final class Greet{}`: Class cannot be inherited.
- `public void sayHello(){}`: Instance method cannot be overridden in subclass.
- `public static void sayHello(){}`: Static method cannot be hidden in subclass.


A more reliable way to store constants is to use an enumerated type (also called
an enumeration type). An enumerated type is a class all of whose possible
instances are explicitly enumerated during initialization.


```java

public enum Size { 
    SMALL, MEDIUM, LARGE
};


```
