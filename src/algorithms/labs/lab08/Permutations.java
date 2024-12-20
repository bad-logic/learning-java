package algorithms.labs.lab08;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(List<List<Integer>> result, List<Integer> permutation, int[] nums){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return result;
        }

        for(int n: nums){
            if(permutation.contains(n)) continue;
            permutation.add(n);
            permute(result,permutation,nums);
            permutation.removeLast();
        }

        return result;
    }
    public static List<List<Integer>> permute(int[] nums) {
        return permute(new ArrayList<>(), new ArrayList<>(), nums);
    }

    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3,4}));
    }
}
