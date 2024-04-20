package modernpractises.labs.Lab09.lab09_06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public Set<String> union(List<Set<String>> sets){
        return sets.stream().reduce(new HashSet<String>(),(x, y)-> {
            x.addAll(y);
            return x;
        });
    }

    public static void main(String[] args){
        HashSet<String> h1 = new HashSet<String>(List.of("A", "B"));

        HashSet<String> h2 = new HashSet<String>(List.of("D"));

        HashSet<String> h3 = new HashSet<String>(List.of("1", "3", "5"));

        System.out.println(new Solution().union(List.of(h1,h2,h3)));
    }

}
