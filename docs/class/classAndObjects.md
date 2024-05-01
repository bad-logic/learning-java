## Class And Objects

Class is at the core of Java. It is the logical construct upon which the entire Java language is built because it defines the shape and nature of an object. As such, the class forms the basis for object oriented programming in java. Any concept you wish to implement in a java program must be encapsulated within a class.

When you define a class, you declare its exact form and nature. you do this by specifying the data that it contains and the code that operates on that data. while very simple classes may contain only code or only data, most real-world classes contain both.

```java
public class Rectangle{
 double width;
 double length;
}

```

### Object Creation:

When you create a class, you are creating a new data type. you can use this type to declare variable of the class type. This variable does not define an object. Instead, it is simply a variable that can refer to an object. second, you must acquire an actual physical copy of the object and assign it to that variable. you can do this using the `new` operator.

```java
Rectangle myRectangle; // declare reference to object

myRectangle = new Rectangle(); // allocate memory
```

The new operator dynamically allocates memory for the object and calls a constructor to initialize object state. If a constructor is not explicitly defined a default constructor is added by the java. You can see this by compiling it with javac and looking into the .class file generated. Here in the above case the default constructor will look like below:

```java
public class Rectangle{    
    double length;
    double width;
   
		// default constructor
    public Rectangle() {
    }
}
```

### Creating a constructor

```java
public class Rectangle{
  double length;
  double width;
  
  public Rectangle(double l, double w){
   this.length = l;
   this.width = w;
 }
 
}
```

- The constructor defined above is a parameterized constructor.
- Default constructor added by java has no parameters. 
- If you want to initialize the values of an object during creation then you would need to create a parameterized constructor.
- Unlike other methods, constructors can only be called with new operator.

### This Keyword.

The `this` keyword inside a class methods refers to the object that is invoking the methods.

Information (Data) Hiding :

| Access Modifiers → | private  | protected | default | public |
| --- | --- | --- | --- | --- |
| same class | yes | yes | yes | yes |
| same package sub class | no | yes | yes | yes |
| same package non sub class | no | yes | yes | yes |
| different package sub class | no | yes | no | yes |
| different package non sub class | no | no | no | yes |

### Encapsulation:

- Encapsulation is a way to restrict direct access to the internal state of an object.
- Permits the class that owns the data to control access to the data.
- Getters (Accessor) and setters (Mutator) support "encapsulation".

### Instance Fields:

- They are created in heap and are bounded with the objects.
- Each instance has their own instance fields.
- Lifecycle starts with object creation and ends with object destruction.


### Instance Methods:

- They are methods that can be called by the objects to perform some computation.
- object should be created to call the instance methods.


### Static Fields:
- They are created in static storage a.k.a method area.
- it uses the keyword `static`  as a part of the declaration.
- A value for static variable is shared among all instances of the class.
- Lifecycle begins as the class in loaded in the memory and ends when the program exits.


### Static Methods:

- They are utility methods that provide service of some kind.
- They can be called without creating any objects, by using classname.
- They cannot access instance variables.
- syntax: `public static <return_type> <func_name>(<params>)` .