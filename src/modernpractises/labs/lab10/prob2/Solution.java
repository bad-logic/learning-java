package modernpractises.labs.lab10.prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static <T extends Comparable<T>> T secondSmallest(List<T> list){
        if(list.isEmpty()) return null;
        if(list.size() == 1) return null;
        // creating a mutable lists since Collections.sort requires modifiable list
        ArrayList<T> lst = new ArrayList<T>(list);
        Collections.sort(lst);
        return lst.get(1);
    }

    public static void main(String[] args) {

        // List.of => returns immutable list
        System.out.println(Solution.secondSmallest(List.of("ab","abc","aaa","nice")));
        System.out.println(Solution.secondSmallest(List.of(1,2,3,4,6)));
        System.out.println(Solution.secondSmallest(List.of(1.4,1.5,9.9,8.7)));

    }

}
