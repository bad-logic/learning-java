package algorithms.labs.lab09;

import java.util.Arrays;


/**
 *
 * Time complexity => O(# of self calls * work on each self call ) => O(height of the tree * iteration of coins )
 * => O(amount * n ) => O(n*k); n = # of coins, k = amount
 * Space complexity => O(total stack used by recursion) + O(array of size amount + 1) => O(amount) + O(amount) => O(amount)
 *
 */
public class CoinChangeRecursiveDP {

    private static int countMinimumCoinsRequiredToReachTargetRecursive(int[] table, int[] coins, int amount){

        if(amount==0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        if(table[amount] == -2){ // for this amount minimum cost/steps is not computed so compute
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                int result = countMinimumCoinsRequiredToReachTargetRecursive(table, coins,amount-coin);
                if(result!=-1 && result < min){
                    min = result;
                }
            }

            table[amount] = min==Integer.MAX_VALUE ? -1 : 1+min;
        }
        return table[amount];
    }

    public static int countMinimumCoinsRequiredToReachTargetRecursive(int[] coins, int amount){
        int[] table = new int[amount+1];
        Arrays.fill(table,-2);

        int minSteps = countMinimumCoinsRequiredToReachTargetRecursive(table,coins,amount);
        System.out.println(Arrays.toString(table));
        return minSteps;
    }

    public static void main(String[] args){
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{1,2,5},11)); // 3
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{1,2,5},10)); // 2
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{2},3)); // -1
    }

}
