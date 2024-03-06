package fundamentals.practise.oop;

import java.lang.reflect.InvocationTargetException;

abstract class AbstractTest{
    public void display(){}
    public void sayHello(){}
}

class Test{
    public void display(){
        System.out.println("Parent display");
    }
    public void sayHello(){
        System.out.println("Parent sayHello");
    }
}
interface ITest {
    public void display();
    public void sayHello();
}

public class Nested {
//    static ITest inner;
//    static AbstractTest inner;
    static Test inner;
    void Nested(){}

    public String toString(){
        return "Hello";
    }

     void createClass(){
//        class Inner implements ITest{
//         class Inner extends AbstractTest{
         class Inner extends Test{
            int x = 6;
            int hello(){
                return 5;
            }
            public void display(){
                System.out.println(this.x);
            }
            public void sayHello(){
                System.out.println("Hello");
            }

            public String toString(){
                return ">>"+this.x;
            }
        }
        inner = new Inner();

    }

    public void executeInnerClassMethods() {
//        System.out.println(inner.toString());
//        inner.display();
//        inner.sayHello();

//        System.out.println( inner );


        try{
            var newObject = inner.getClass().getConstructor().newInstance();
            newObject.display();
          // System.out.println(originalClass.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        Nested nn = new Nested();
        nn.createClass();
        nn.executeInnerClassMethods();
    }
}


