### Instance Block vs Static Block


| Static Block                                                                                          | Instance Initializer Block                                        |
|-------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| It executes during class loading                                                                      | It executes during class instantiation                            |
| It can only use static variables                                                                      | It can use static or non-static (instance variables).             |
| It can not use this keyword                                                                           | It can use this keyword                                           |
| It executes only once during the entire execution of the program when the class loads into the memory | It can run many times whenever there is a call to the constructor |


> The Java compiler copies initializer blocks into every constructor. Therefore, this approach can be used to share a block of code between multiple constructors.


Example:

```java
public class Test{

        int a,b;
        static int c = 55;

        static{
            System.out.println("Super:static block");
        }

        {
            this.a = c;
            this.b = c;
            System.out.println("Super:instance block: a" + this.a +", b:" + this.b);
        }

        public Test(){
            System.out.println("This is super default constructor");
        }

        public Test(int a, int b){
            this.a = a;
            this.b = b;
            c = 66;
            System.out.println("This is super parameterized constructor");
        }

    public static void main(String[] args){
        new Test();
    }
}
```

if we compile the above code using java compiler and have a look at the .class file we can
see that the initializer blocks are being copied inside the constructor like so.

```java

public class Test {
    int a;
    int b;
    static int c = 55;

    public Test() {
        this.a = c;
        this.b = c;
        System.out.println("Super:instance block: a" + this.a + ", b:" + this.b);
        System.out.println("This is super default constructor");
    }

    public Test(int var1, int var2) {
        this.a = c;
        this.b = c;
        System.out.println("Super:instance block: a" + this.a + ", b:" + this.b);
        this.a = var1;
        this.b = var2;
        c = 66;
        System.out.println("This is super parameterized constructor");
    }

    public static void main(String[] var0) {
        new Test();
    }

    static {
        System.out.println("Super:static block");
    }
}

```