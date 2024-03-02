
package fundamentals.practise.static_;

class StaticKeyword{

    static int a = 5; // static variable
    int b = 10; // instance variable

    static { // executes ones when the class is loaded in the memory
        System.out.println("Static Block");
        // b = 34; // error: non-static variable b cannot be referenced from a static context
    }

    {
        System.out.println("Instance Block"); // executed while creating object
        b = 32;
    }

    public static void test(){
        int a; // local variable has no initialization
        // System.out.println(a); // not initialized
    }

    public StaticKeyword(){
        System.out.println("Constructor");
    }

    public static void main(String[] args){
        new StaticKeyword();
        test();
    }
}