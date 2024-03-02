// Execution order
// 1. static variable
// 2. static block
// 3. instance variables
// 4. instance blocks
// 5. constructor

package fundamentals.practise.executionorder;

class Execution{
    @SuppressWarnings("unused")
    private static int staticInt = staticMethod();
    @SuppressWarnings("unused")
    private int number = initializeVariable();

    public static int staticMethod(){
        System.out.println("1-Initializing static variable staticInt");
        return 1;
    }

    public int initializeVariable() {
        System.out.println("3-Initializing instance variable");
        return 1;
    }

    static {
        //Static initialization block
        System.out.println("2-Executing static block");
    }

    {
        //Object initialization block
        System.out.println("4-Running object initialization block");
    }

    Execution(int num){
        this.number = num; //problem?
        System.out.println("5-Running ClassE constructor");
    }
    public static void main(String[] args) {
        new Execution(3);
    }

}