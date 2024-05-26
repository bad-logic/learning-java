## Proxy Pattern

Consider the following class. 
It is representing a class that is very expensive to instantiate. 
It takes 10 seconds or more to create an instance of it. 
So, we wish to create a VirtualProxy in front of it so that the real subject gets instantiated only 
if someone calls veryComplicatedTask() method of this class. Try implementing it using Java Dynamic Proxy.

Hint: You may need to extract an interface from this type.

```java

public class ComplexClass {

    public ComplexClass() throws InterruptedException {

        super();

        Thread.sleep(10000);

    }

    public void veryComplicatedTask() {

        System.out.println("Very complicated task...");

    }

}
```
