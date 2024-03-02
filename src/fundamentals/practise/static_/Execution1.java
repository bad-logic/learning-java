package fundamentals.practise.static_;

public class Execution1 {
    private static int staticInt = 1;

    private int number = 2;

    static {
        //Static initialization block
        System.out.println("Static block");
    }

    {
        //Object initialization block
        System.out.println("Object initialization block");
    }

    Execution1(int num){
        this.number = num;
        System.out.println("Constructor hello");
    }

    public static int staticMethod(){
        System.out.println("Hello");
        return 1;
    }


    public static void main(String[] args) {
        new Execution1(3);
    }

}
