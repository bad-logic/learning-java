package algorithms.labs.lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubsetSum {
    public static List<List<Integer>> powerSet(int[] nums){
        return powerSetRec(new ArrayList<>(), new ArrayList<>(),nums,0);
    }

    private static List<List<Integer>> powerSetRec(List<List<Integer>> ret,
                                                   List<Integer> subset, int[] nums, int i) {
        //base case
        if(i == nums.length) {
            ret.add(new ArrayList<>(subset));
            return ret;
        }
        powerSetRec(ret, subset, nums, i + 1);
        subset.add(nums[i]);
        powerSetRec(ret, subset, nums, i + 1);
        subset.remove(subset.size()-1);
        return ret;
    }

//        public static List<List<Integer>> subsetSum(int[] nums, int sum){
//        List<List<Integer>> powerSet = powerSet(nums);
//        List<List<Integer>> result = new ArrayList<>();
//
//        for(List<Integer> arr: powerSet){
//            Optional<Integer> total = arr.stream().reduce(Integer::sum);
//            if(total.isPresent() && total.get()==sum){
//                result.add(arr);
//            }
//        }
//        return result;
//    }



//    public static List<List<Integer>> subsetSum(int[] nums,int target){
//        return subsetSum(new ArrayList<>(), new ArrayList<>(),nums,0,target);
//    }
//    // 100%
//    private static List<List<Integer>> subsetSum(List<List<Integer>> ret,
//                                                   List<Integer> subset, int[] nums, int i,int target) {
//        //base case
//        if(i == nums.length) {
//            Optional<Integer> total = subset.stream().reduce(Integer::sum);
//            if(total.isPresent() && total.get()==target){
//                ret.add(new ArrayList<>(subset));
//            }
//            return ret;
//        }
//        subsetSum(ret, subset, nums, i + 1,target);
//        subset.add(nums[i]);
//        subsetSum(ret, subset, nums, i + 1,target);
//        subset.remove(subset.size()-1);
//        return ret;
//    }



    public static List<List<Integer>> subsetSum(int[] nums,int target){
        return subsetSum(new ArrayList<>(), new ArrayList<>(),nums,0,target);
    }

    private static List<List<Integer>> subsetSum(List<List<Integer>> ret,
                                                 List<Integer> subset, int[] nums, int i,int target) {
        // since all elements in nums are positive
        if(target < 0){
            return ret;
        } else if (target == 0) {
            ret.add(new ArrayList<>(subset));
            return  ret;
        }
        // base case
        if(i == nums.length) {
            return ret;
        }

        subsetSum(ret, subset, nums, i + 1,target);
        subset.add(nums[i]);
        subsetSum(ret, subset, nums, i + 1,target-nums[i]);
        subset.remove(subset.size()-1);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(powerSet(nums));
        System.out.println(subsetSum(nums,6));
    }
}
