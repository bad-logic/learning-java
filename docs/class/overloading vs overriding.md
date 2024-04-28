## Overloading vs Overriding

[reference](https://www.digitalocean.com/community/tutorials/overriding-vs-overloading-in-java)

> Overriding occurs when the method signature is the same in the superclass and the child class. Overloading occurs when two or more methods in the same class have the same name but different parameters.

| Overriding | Overloading |
| -------- | ------- |
| Implements “runtime polymorphism”	 | Implements “compile time polymorphism”|
| The method call is determined at runtime based on the object type	 | The method call is determined at compile time
|
| Occurs between superclass and subclass	 | Occurs between the methods in the same class
|
| Have the same signature (name and method arguments) | Have the same name, but the parameters are different
|
| On error, the effect will be visible at runtime	 | On error, it can be caught at compile time
|

Example: 
```java

import java.util.Arrays;

public class Processor {

    public void process(int i, int j) {
        System.out.printf("Processing two integers:%d, %d", i, j);
    }

    public void process(int[] ints) {
        System.out.println("Adding integer array:" + Arrays.toString(ints));
    }

    public void process(Object[] objs) {
        System.out.println("Adding integer array:" + Arrays.toString(objs));
    }
}

class MathProcessor extends Processor {

    @Override
    public void process(int i, int j) {
        System.out.println("Sum of integers is " + (i + j));
    }

    @Override
    public void process(int[] ints) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        System.out.println("Sum of integer array elements is " + sum);
    }

}
```
