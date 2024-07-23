## Dynamic Binding vs Static Binding

If a method to be invoked can be binded (pinpointed or determined) at compile time then the binding is known as static binding,
if it can only be determined at run time it is known as dynamic binding.

```java
interface Test{
    void m();
}
class A implements Test{
    public void m(){
    }
}

class B implements Test{
    public void m(){
    }
}
class C{
    public static void main(String[] args){
        A a = new A();
        a.m();// we know that m() of a is going to be called 
        
        Test b = new B();
        b.m(); // we do not know which m() will be called until runtime because Interface Test reference makes it polymorphic
    }
}


```
 
| Late Binding                                                       | Early Binding                                                                               |
|--------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| The method call is determined at runtime based on the object type	 | The method call is determined at compile time                                               |
| Implements “runtime polymorphism”	                                 | Implements “compile time polymorphism”                                                      |
| On error, the effect will be visible at runtime	                   | On error, it can be caught at compile time                                                  |
| applied for overridden methods and dynamic polymorphic methods     | applied for overloaded method, private methods, static methods, final methods and variables |  


```java

class Super{
    protected int x = 9;

    public int getX() {
        return x;
    }

    public void implementMe(){
        System.out.println("hello " + x);
    }

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
            Variable Access do not use Dynamic Binding.
            The variable value is associated with the static type at
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