package fundamentals.practise.memory_pool;

public class StringIntern {

    public static void main(String[] args) {
        String s = "Bob"; //string literal, placed in String pool
        String t = new String("Bob"); //not placed in String pool

        System.out.println(s==t);  //not identical strings
        //System.out.println(s.equals(t));
        t = t.intern();  //now it is forced into the String pool

        System.out.println(s==t);

        //moral: the string literal "Bob" is created by (new String("Bob")).intern() )



    }
}
