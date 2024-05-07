## Overloading

### Overloading Methods
> In Java, it is possible to define two or more methods within the same class that share the same name as long as their parameter declarations are different.
> if this is the case the methods are said to be overloaded and the process is referred to as method overloading.


> To say a method is overloaded, there must be at least two methods in a class having the same name but different signature.
> The signature of a method is the combination of the method's name along with the number and types of the parameters , and the order in which they occur.

- It is one of the way to support polymorphism in java.

### Order of overloaded methods
Whenever an overloaded methods are called java will first look for the exact matching function signature, if this is not found
then java will perform automatic type conversions to resolve the call.

Java will look for match in the following order if exact match is not found.
1. exact match by type
2. larger primitive type
3. Autoboxed type
4. varargs


```java

import java.util.Arrays;

public class Processor {

    public void process(int i, int j) {
        System.out.println("Processing two integers: "+ i + ", "+ j);
    }

    public void process(int[] ints) {
        System.out.println("Processing int array:" + Arrays.toString(ints));
    }

    public void process(Object[] objs) {
        System.out.println("Processing Object array:" + Arrays.toString(objs));
    }
    
    public static void main(String[] args){
        Processor pr = new Processor();
        short a = 8;
        short b = 9;
        int c = 99;
        int d = 100;
        pr.process(a,b); // invokes process(int,int)
        pr.process(c,d); // invokes process(int,int)
        pr.process(new Integer[] {4567,78902,345,454}); // invokes process(Object[])
    }
}


```

In the above example the `process` methods are overloaded.<br>
Also in main method, we can see that there is no any overloaded process method that accepts short type as argument, but since exact type is not found java 
will look for bigger primitive type which is int, so the process method with int args is invoked.