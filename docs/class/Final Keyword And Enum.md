## Constants And Enum


### Final Keyword
- `private final String name;` : name field can never be changed.
- `public static final int TAX_RATE;` : TAX_RATE is considered to be a constant.


A more reliable way to store constants is to use an enumerated type (also called
an enumeration type). An enumerated type is a class all of whose possible
instances are explicitly enumerated during initialization.


```java

public enum Size { 
    SMALL, MEDIUM, LARGE
};


```
