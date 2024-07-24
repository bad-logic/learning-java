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

### Enum

```java

import java.util.Arrays;

enum Subscription{
    BRONZE,SILVER,GOLD,PLATINUM,DIAMOND // enumeration constants
}

class Main {

    public static void main(String[] args){
        System.out.println(Arrays.toString(Subscription.values())); // [GOLD, SILVER, BRONZE, PLATINUM, DIAMOND]
        
        System.out.println(Subscription.valueOf("SILVER")); // SILVER
    }

}

```

- java enumerations are a class type.
- by default enums inherit from java.lang.Enum class.
- but you do not instantiate enum using new keyword, it cannot inherit, nor be extended.
- apart from that it has the same capabilities as other classes.

```java

enum Subscription{
    BRONZE,SILVER(1),GOLD(2),PLATINUM(3),DIAMOND(4);

    private final int val;

    Subscription(){
        this.val = 0;
    }
    
    Subscription(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

class Main {

    public static void main(String[] args){
        System.out.println(Subscription.valueOf("SILVER")); // SILVER
        for(Subscription s : Subscription.values()){
            System.out.println(s.toString()+ ": " + s.getVal());
        }
    }

}

```

- `ordinal()` method can be called on the enumeration constants to get its position in the list of constants.

```java

enum Subscription{
    BRONZE,SILVER,GOLD,PLATINUM,DIAMOND
}

class Main {

    public static void main(String[] args){
        System.out.println(Subscription.valueOf("SILVER")); // SILVER
        for(Subscription s : Subscription.values()){
            System.out.println(s +": " + s.ordinal());
        }
        System.out.println();

        // using compareTo to compare
        System.out.println(Subscription.PLATINUM.compareTo(Subscription.GOLD));
        System.out.println(Subscription.GOLD.compareTo(Subscription.GOLD));
        System.out.println(Subscription.PLATINUM.compareTo(Subscription.DIAMOND));

        System.out.println();
        
        // using equals
        System.out.println(Subscription.PLATINUM.equals(Subscription.GOLD));
    }

}


```

