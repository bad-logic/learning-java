package algorithms.labs.lab09;

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

import java.util.Arrays;

/**
 *
 */
public class ClimbingStairsDP {
    private static int climbStairs(int[] table, int[] options, int target){
        if(target==0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(table[target]==-3){
            int count = 0;
            for(int option:options){
                count += climbStairs(table,options,target-option);
            }
            table[target] = count;
        }
        return table[target];
    }

     public static int climbStairsRecursiveDP(int n) {
         int[] table= new int[n+1];
         Arrays.fill(table,-3);

         int steps = climbStairs(table,new int[]{1,2},n);
         System.out.println(Arrays.toString(table));
         return steps;
     }

    public static int climbStairsIterativeDP(int n){
        int[] options = new int[]{1,2};
        int[] table= new int[n+1];
        Arrays.fill(table,-3);
        table[0] = 1;
        for(int i=1;i<=n;i++){
            if(table[i]==-3){
                int steps = 0;
                for(int option: options){
                    int remainingSteps = i - option;
                    if(remainingSteps>=0){
                        steps += table[remainingSteps];
                    }
                }
                table[i] = steps;
            }
        }

        return table[n];
    }

     public static void main(String[] args){
         System.out.println(climbStairsIterativeDP(2)); // 2
         System.out.println(climbStairsIterativeDP(3)); // 3
         System.out.println(climbStairsIterativeDP(44)); // 1134903170
     }
}
