
// order of overloaded methods
// 1. exact match by type
// 2. larger primitive type
// 3. AutoBoxed type
// 4. var arg

package fundamentals.practise.classes;

public class Overloading{

    public static void display(int a){
        System.out.println("int");
    }

    public static void display(long a){
        System.out.println("long");
    }

    public static void display(Integer a) {
        System.out.println("Integer");
    }

    public static void display(int ...a){
        System.out.println("varargs");
    }

    public static void main(String[] args){
        display(5);
    }
}