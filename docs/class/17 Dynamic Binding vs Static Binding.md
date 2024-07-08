## Dynamic Binding vs Static Binding

Late binding is Resolving calls to methods dynamically at runtime.
 
| Late Binding                                                       | Early Binding                                        |
|--------------------------------------------------------------------|------------------------------------------------------|
| Implements “runtime polymorphism”	                                 | Implements “compile time polymorphism”               |
| The method call is determined at runtime based on the object type	 | The method call is determined at compile time        
|
| Occurs between superclass and subclass	                            | Occurs between the methods in the same class         
|
| Have the same signature (name and method arguments)                | Have the same name, but the parameters are different 
|
| On error, the effect will be visible at runtime	                   | On error, it can be caught at compile time           
|




| Dynamic Binding | Static Binding|
| --------------- | ------------- |
| late,runtime | early, compile time | 
| override | overloaded |


```java

class Super{
    protected int x = 9;

    public int getX() {
        return x;
    }

    public void implementMe(){
        System.out.println("hello " + x);
    };

}

public class Test extends Super{
    private final int x = 90;
    /**
     *
     */
    @Override
    public void implementMe() {
        System.out.println("implemented "+ x);

    }

    public int getX() {
        return x;
    }

    public static void main(String[] args){
         Super s1 = new Super();
        System.out.println(s1.x);
        System.out.println(s1.getX());
        s1.implementMe();

        System.out.println("\n\n");

//        Test t = new Test();
        Super t = new Test();
        /*
            Variable Access Does Not Use Dynamic Binding.
            Access of variables does not use
            dynamic binding. The variable value
            is associated with the static type at
            compile time
         */
        System.out.println(t.x);

        int z = t.x;
        System.out.println(z);

        System.out.println(t.getX());
        t.implementMe();
    }
}

```