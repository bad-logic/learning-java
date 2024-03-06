package fundamentals.labs.lab05.lab05_03;

import java.util.Arrays;

public class MainLambda {

    public static void main(String[] args){

        StringSort ss = new StringSort(( o1,  o2) -> o2.length() - o1.length());

        String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };
        ss.stringSort(testStrings);

        System.out.println(Arrays.asList(testStrings));
    }

}
