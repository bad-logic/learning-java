package algorithms.labs.lab02;
// PSEUDO CODE

//Algorithm: PowerSet(X)
//    Input: A list X of elements
//    Output: A list P consisting of all subsets of X – elements of P are Sets
//    P ← new list
//    S ← new Set //S is the empty set
//    P.add(S) //P is now the set { S }
//    T ← new Set
//    while (!X.isEmpty() ) do
//        f ← X.removeFirst()
//        for each x in P do
//            T ← x U {f} // T is the set containing f & all elements of x
//            P.add(T)
//    return P

import java.lang.reflect.Array;
import java.util.*;

public class PowerSet {
    public static <T> List<Set<T>> powerSet(List<T> x){
        List<Set<T>> result = new ArrayList<>();
        Set<T> temp = new HashSet<>();
        result.add(temp); // adding empty set

        while(!x.isEmpty()){
            T removedItem = x.removeFirst();
            for(Set<T> set : new ArrayList<>(result)){
                result.add(new HashSet<>(){{
                    addAll(set);
                    add(removedItem);
                }});
            }
        }

        return result;
    }

    public static Set<Integer> subsetWithSum(List<Integer> list, int sum){
        if(sum==0) return new HashSet<>();
        for(Set<Integer> lst : powerSet(list)){
            Optional<Integer> total = lst.stream().reduce(Integer::sum);
            if(total.isPresent() && total.get() == sum){
                return lst;
            }
        }
        return null;
    }

    public static void main(String[] args){
//        System.out.println(powerSet(new ArrayList<>(){{
//            add(1);
//            add(3);
//            add(2);
//        }}));

        System.out.println(subsetWithSum(new ArrayList<>(){{addAll(Arrays.asList(1, 3, 9, 4, 8, 5));}} ,21));
        System.out.println(subsetWithSum(new ArrayList<>(){{addAll(Arrays.asList(1, 3, 9));}} ,5));
        System.out.println(subsetWithSum(new ArrayList<>(){{addAll(Arrays.asList(1, 3, 9, 4, 8, 5));}} ,0));
    }
}
