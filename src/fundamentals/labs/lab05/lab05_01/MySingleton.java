package fundamentals.labs.lab05.lab05_01;

public class MySingleton {
    final static private MySingleton instance;
    static int count = 0;

    static {
        instance = new MySingleton();
    }

    // private constructor
    // preventing users from creating multiple instances
    private MySingleton(){
        count++;
    }

    public static MySingleton getInstance(){
        return instance;
    }

    public void print(String s){
        System.out.println(s);
    }

}
