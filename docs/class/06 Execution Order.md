## Execution Order

Sequence of execution when a constructor is called

1. If this is the first time the class is loaded into memory, all static fields are given
    default initialization, and then all static fields are initialized and static initialization
    blocks are run in the order in which they appear in the class file.
    (Static fields are initialized only once; static blocks executed only once.)
2. All instance variables are initialized with their default values
3. After instance variables are initialized, constructor body is executed.
4. Inside constructor body java does following:
    1. if there is `super()` call. which can be implicit ( default constructor ) or explicit, then execution
        moves to the parent class constructor.
   2. if there is `this()` call. then the execution will move to the constructor that matches `this()`.
   3. Object initialization blocks are executed, in the order in which they occur in the class file.
   4. If there is a `this()` call then the Object initialization blocks are not executed, since java does not copy the
        initialization blocks to the constructor making `this()` call.
   5. Remaining constructor code blocks are executed.

```java

class Super{
    int a,b;
    static int c = 55;

    static{
        System.out.println("Super:static block");
    }
    
    static{
        System.out.println("Super:second static block");
    }


    {
        this.a = c;
        this.b = c;
        System.out.println("Super:instance block: a"+this.a+", b:"+this.b);
    }
    
    {
        System.out.println("Super:second instance block");
    }
    
    public Super(){
        System.out.println("This is super default constructor");
    }
    public Super(int a, int b){
        this.a = a;
        this.b = b;
        c = 66;
        System.out.println("This is super parameterized constructor");
    }

    public void override(){
        System.out.println("hey i am parent overload");
    }

    static public void  stat(){
        System.out.println("hey i am parent static");
    }

    public void justCallMe(){
        this.override();
        Super.stat();
    }
}

public class Test extends Super{

    static{
        System.out.println("This is a static block of test class");
    }

    {
        System.out.println("This is a instance block of test class");
    }
    public Test(){
        System.out.println("This is test default constructor");
    }

    public Test(int a, int b){
        super(a,b);
        System.out.println("This is test parameterized constructor");
    }

    static public void  stat(){
        System.out.println("hey i am child static");
    }

    public void override(){
        System.out.println("hey i am child overload");
    }

    public void justCallMe(){
        super.justCallMe();
    }
    
    public static void main(String[] args){
        Test t1 = new Test(1,1);
        t1.justCallMe();
        System.out.println("a: " + t1.a + "b: "+ t1.b);
        Test t = new Test();
        System.out.println("a: " + t.a + "b: "+ t.b);
    }
}

```

```shell
# output

Super:static block
Super:second static block
This is a static block of test class
Super:instance block: a55, b:55
Super:second instance block
This is super parameterized constructor
This is a instance block of test class
This is test parameterized constructor
hey i am child overload
hey i am parent static
a: 1b: 1
Super:instance block: a66, b:66
Super:second instance block
This is super default constructor
This is a instance block of test class
This is test default constructor
a: 66b: 66
```