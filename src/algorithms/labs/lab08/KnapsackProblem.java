package algorithms.labs.lab08;

//Devise an algorithm for the following problem using backtracking.
//Knapsack Problem. Given a set S = {s0, s1, …, sn-1} of items, weights {w0, w1,…, wn-1}
//and values {v0, v1, …, vn-1} , a max weight W and a min value V, find all subsets T of S
//whose total value at least V and total weight is at most W.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    private static List<List<Integer>> knapsack(List<List<Integer>> result,int[] s,int[] w, int[] v, int maxW, int minV, List<Integer> subset, int currIndex){

        if(maxW >= 0 && minV <= 0){
            result.add(new ArrayList<>(subset));
            // do not return, because we can still find the other combinations
        }
        if(currIndex == s.length){
            return result;
        }

        knapsack(result,s,w,v,maxW, minV, subset, currIndex +1);
        subset.add(s[currIndex]);
        knapsack(result,s,w,v,maxW-w[currIndex], minV-v[currIndex], subset, currIndex +1);
        subset.removeLast();
        return result;
    }
    public static List<List<Integer>> solve(int[] s,int[] w, int[] v, int maxW, int minV){
        return knapsack(new ArrayList<>(),s,w,v,maxW, minV,new ArrayList<>(),0);
    }

    public static void main(String[] args){
        System.out.println(solve(new int[]{1,2,3},new int[]{4,8,9},new int[]{2,4,6},14,5));
    }
}
