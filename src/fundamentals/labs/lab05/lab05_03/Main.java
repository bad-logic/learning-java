package fundamentals.labs.lab05.lab05_03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringSort ss = new StringSort(new StringLengthComparator(false));

        String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };
        ss.stringSort(testStrings);

        System.out.println(Arrays.asList(testStrings));
    }


}
