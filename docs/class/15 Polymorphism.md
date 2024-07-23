## Polymorphism
- having multiple forms

let's look at an example,

```java
class Animal {
  public void says() {
    System.out.println("animal sound");
  }
}

class Pig extends Animal {
  public void says() {
    System.out.println("wee wee");
  }
}

class Dog extends Animal {
  public void says() {
    System.out.println("bow wow");
  }
}

class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();  // Create a Animal object
        Animal myPig = new Pig();  // Create a Pig object
        Animal myDog = new Dog();  // Create a Dog object
        myAnimal.says();
        myPig.says();
        myDog.says();
    }
}

```

In above example even though the type of all objects is Animal, they behave differently based on the
object created in run time. This ability to behave differently based on the type of the object is known as polymorphism.

### In java polymorphism can be achieved with:
- Method overriding ( Inheritance ) // dynamic polymorphism
- Method overloading // static polymorphism
- Interface
- Abstract class

### Two types of polymorphism
- static polymorphism ( Compile Time Polymorphism ):  
    > when multiple methods with same name have different sets or type of parameters, each one becomes a unique method with different signatures.
    Since, they have same name, when we call them with different arguments, they behave differently. this exerts the polymorphic behaviour
    which can be observed during compile time known as compile time polymorphism or static polymorphism.
  > Here, the method to be invoked is determined at compile time based on the method signature.

```java
public class Processor {
  public Processor(){}

  public void process(int i, int j) {
    System.out.println("Processing two integers: "+ i + ", "+ j);
  }

  // overloading process method
  public void process(int[] ints) {
    System.out.println("Processing int array:" + Arrays.toString(ints));
  }

  // overloading process method
  public void process(Object[] objs) {
    System.out.println("Processing Object array:" + Arrays.toString(objs));
  }
    
    public static void main(String[] args){
      Processor pr = new Processor();
      pr.process(8,9); // invokes process(int,int)
      pr.process( new int[] {1,2,3}); // invokes process(int[])
      pr.process(new Integer[] {4567,78902,345,454}); // invokes process(Object[])
    }
}
```

In above code snippet, we are calling process methods of Processor object with different number and types of parameters.
Based on the type and number of parameters the Java compiler binds this method call to the respective methods of the Processor object
at compile time. Thus, polymorphic behaviour can be seen at compile time a.k.a compile time or static polymorphism.

- Dynamic polymorphism ( Run-Time Polymorphism ):
    >  Within an inheritance hierarchy, a subclass can override a method of its superclass, enabling the developer of the subclass to customize 
        or completely replace the behavior of that method. The method to be invoked is determined at runtime based on the object’s actual type.

|                  | static                                                    | dynamic                                                         |
|------------------|-----------------------------------------------------------|-----------------------------------------------------------------|
| Binding Time     | compile time                                              | Run time                                                        | 
| Achieved Through | method overloading                                        | method overriding                                               | 
| Flexibility      | less flexible, method to be invoked should be known ahead | method to be invoked is not known until runtime                 |
| Performance      | faster, method is already known at compile time           | has overhead of determining the method to be invoked at runtime |

