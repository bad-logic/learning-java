package fundamentals.labs.lab05.lab05_03;

import java.util.Comparator;

import java.util.Arrays;

public class MainAnonymous {

    public static void main(String[] args){

        StringSort ss = new StringSort(new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };
        ss.stringSort(testStrings);

        System.out.println(Arrays.asList(testStrings));
    }
}
