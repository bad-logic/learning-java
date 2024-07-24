## Boxed Primitives  ( Type Wrappers )

- java uses primitive types ( int, float, double, char ) to hold the basic data types.
- using objects for these values would add an unacceptable overhead to even the simplest of calculations.
- despite the performance benefit offered by the primitives, there are times when you will need an object
  representation.
  E.x:
  i. you cannot pass a primitive type by reference to a method.
  ii. many standard data structures implemented by java operate on objects, you can't use primitives.
- To handle this kind of situation java provides type wrappers, which are classes that encapsulate a primitive
  type within an object.
- Java provides immutable wrapper classes for all primitive types:

| primitives | Wrapper Class |
| --- | --- |
| short | Short |
| byte | Byte |
| int | Integer |
| long | Long |
| char | Character |
| boolean | Boolean |
| float | Float |
| double | Double |

```java

    Integer a = Integer.valueOf(5);
    Integer b = 8;
    int c = b.intValue();

```
- Modern versions of java have included two important features:

### AutoBoxing: 
- process by which a primitive type is automatically encapsulated ( boxed ) into its equivalent type wrapper whenever an object of that type is needed.

### Auto-unboxing:
- process by which the value of a boxed object is automatically extracted ( unboxed ) from a type wrapper when its value is needed.

```java
    Integer num1 = 100; // auto box int to Integer

    int i = num1; // auto unboxing 
    
```

- Autoboxing and Auto-unboxing happens where the other types are needed.
- for example:

```java

public static void main(String[] args){
    Boolean b = true;
    if(b){
      system.out.println("hello");
    }
}

```

- Since wrapper Boolean is used inside if condition, it is auto unboxed to primitives and the condition is checked.
- Auto unboxing happens automatically during conditional expression of while, for, or do while loops.

> `warning`: Although using wrapper types is completely fine, it adds an overhead of auto boxing and unboxing, so it is better to use
> primitives and only use wrappers where the object representation of a primitive type is required.


#### Boxed Primitive Methods
- Integer.parseInt(), Double.parseDouble()
- compareTo - works the same way as [string](../fundamentals/17.%20String.md)