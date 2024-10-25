package algorithms.labs.lab09;


//Given an integer array of different coin denominations and an
//integer amount representing a total amount of money. Return
//the fewest number of coins that you need to make up that
//amount. If that amount of money cannot be made up by any
//combination of the coins, return -1. You may assume that you
//have an infinite number of each kind of coin.
//        Example 1:
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//Input: coins = [2], amount = 3
//Output: -1

/**
 *
 * Time complexity => O(# of coins ^ amount ) => O(n^k); n = # of coins, k = amount
 * Space complexity => total stack used by recursion => length of the tree => O(amount)
 *
 */
public class CoinChangeRecursive {

    public static int countMinimumCoinsRequiredToReachTargetRecursive(int[] coins, int amount){
        if(amount==0){
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int coin : coins) {
            if(amount-coin >= 0){
                int cost = countMinimumCoinsRequiredToReachTargetRecursive(coins, amount - coin);
                if (cost != -1 && cost < minCost) {
                    minCost = cost;
                }
            }
        }

        return minCost==Integer.MAX_VALUE ? -1 : 1 + minCost;
    }

    public static void main(String[] args){
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{1,2,5},11)); // 3
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{2},3)); // -1
    }
}
