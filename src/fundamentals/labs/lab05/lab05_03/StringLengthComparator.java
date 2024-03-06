package fundamentals.labs.lab05.lab05_03;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>{

    boolean ascending;
    StringLengthComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(String o1, String o2) {
        return ascending ? (o1.length() - o2.length())   :
                (o2.length() - o1.length());
    }
}
