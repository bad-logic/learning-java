package poolDemo;

public class Pool {

    public static void main(String[] args){
        MyPair myPair = new MyPair(2,3);
        MyPair myPair1 = new MyPair(2,3);

        MyPair myPair2 = myPair.usePool();
        MyPair myPair3 = new MyPair(2,3).usePool();
        MyPair myPair4 = new MyPair(2,3).usePool();
        System.out.println(myPair == myPair1); // false
        System.out.println(myPair == myPair2); // true
        System.out.println(myPair2 == myPair3); // true
        System.out.println(myPair3 == myPair4); // true

        System.out.println();
        System.out.println(myPair.equals(myPair1)); // true
        System.out.println(myPair.equals(myPair2)); // true
        System.out.println(myPair2.equals(myPair3)); //  true
    }

}
