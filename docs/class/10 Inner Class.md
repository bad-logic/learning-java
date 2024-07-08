## Inner Classes

Four Types:
- member inner class
- static inner class
- local inner class
- anonymous inner class

#### Member Inner Class
- It is treated as the instance member of the outer class except it is a class instead of methods or fields.
- It can be declared private, default, protected or public.
- Inner class has direct access to all the fields and methods of enclosing class.
- Outer class can access private variables and methods of inner class through inner class instance.
- unless the inner class is private we can also create an instance of member inner classes with
  outer class instance like so `Outer.PublicInner pi = new Outer().new PublicInner()`.


```java
public class Outer{
    private String greet = "Welcome";
    private int count = 0;

    public void display(){
        Inner i1 = new Inner();

        // able to access private variable through reference from enclosing class
        System.out.println("value from inner: " + i1.value);

        // able to access private method through reference from enclosing class
        i1.display();
    }

    public class PublicInner{
        private void display() {
            System.out.println("this is public inner");
        }
    }

    private class Inner{
        private String greet = "Hello, Welcome";
        private int value = 9;
        private int value1 = Outer.this.count + 5;


        private void display(){
            // accessing count this way first checks if count is available within this class
            // if not checks the extending class and then enclosing class if any
            System.out.println("counter :" + count);
            System.out.println("value1 : " + value1);
            System.out.println(greet);

            // accessing outer greet variable
            System.out.println(Outer.this.greet);
        }
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        outer.display();

        // creating instance of PublicInner
        outer.new PublicInner().display();

        Outer.PublicInner pi = new Outer(). new PublicInner();
        pi.display();

    }
}
```

#### Static Inner Class
- It is defined using the static keyword.
- It can be declared private, default, protected or public.
- Static Inner class has direct access to all the static members of enclosing class but not the instance members.
- They can access enclosing class instance members through enclosing class object.
- Outer class can access private variables and methods of static inner class through inner class instance.
- unless the static inner class is private we can also create an instance of static member inner classes with
  outer class like so `Outer.PublicInner pi = new Outer.PublicInner()`.

```java

public class Outer{
    private static String greet = "Welcome";
    private static int count = 0;

    public void display(){
        Inner i1 = new Inner();

        // able to access private variable through reference from enclosing class
        System.out.println("value from inner: " + i1.value);

        // able to access private method through reference from enclosing class
        i1.display();
    }

    static public class PublicInner{
        private void display() {
            System.out.println("this is public inner");
        }
    }

    static private class Inner{
        private String greet = "Hello, Welcome";
        private int value = 9;
         private static int value1 = Outer.count + 5;


        private void display(){
            // accessing count this way first checks if count is available within this class
            // if not checks the extending class and then enclosing class if any
            System.out.println("counter :" + count);
            System.out.println("value1 : " + value1);
            System.out.println(greet);

            // accessing outer greet variable
            System.out.println(Outer.greet);
        }
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        outer.display();

        // creating instance of PublicInner

        Outer.PublicInner pi = new Outer.PublicInner();
        pi.display();

    }
}

```

#### Local Inner Class
- defined within the body of a method.
- Since they are designed to be accessed within the method body only, no access specifiers ( private, protected, etc) are used.
- they have direct access to the members of the enclosing class as well as the local variables and parameter of the method.


#### Anonymous inner class
- It is a kind of inner class that is defined – without a name – and instantiated in a single block of code.
- It is used to create an "on the fly" subclass of a known class or an "on the fly" implementation of a known interface.

```java

public class Test{

    public static void main(String[] args){
        // using anonymous class inherited from ArrayList
        List<Integer> inlist = new ArrayList<Integer>(){
            {

                add(7);
                add(8);
                add(90);
            }
        };

        System.out.println(inlist);

    }
}

```