package algorithms.labs.lab09;

import java.util.Arrays;


/**
 *
 * Time complexity => O(amount * # of coins) => O(n*k) ; n = # of coins, k = amount
 * Space complexity => O(array of size amount + 1) = O(k); k = amount
 *
 */
public class CoinChangeIterativeDP {

    public static int countMinimumCoinsRequiredToReachTargetRecursive(int[] coins, int amount){
        int[] table = new int[amount+1];
        Arrays.fill(table,-2);
        table[0] = 0; // zero coins needed to make amount zero

        for(int i=1;i<=amount;i++){
            if(table[i] == -2){ // if it's not already computed
                int min = Integer.MAX_VALUE;
                for(int coin: coins){
                    int remainingAmount = i - coin;
                    if(remainingAmount >= 0 && table[remainingAmount]!= -1 && table[remainingAmount] < min){
                        min = table[remainingAmount];
                    }
                }
                table[i] = min==Integer.MAX_VALUE ? -1 : 1 + min;
            }
        }
        System.out.println(Arrays.toString(table));
        return table[amount];
    }

    public static void main(String[] args){
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{1,2,5},11)); // 3
        // amount = 0 => 0 coins
        // amount = 1 => 1 coin
        // amount = 2 => 1 coin
        // amount = 3 => 2 coins
        // amount = 4 => 2 coins
        //     4-1 => table[3] + 1 => 3 coins
        //     4-2 => table[2] + 1 => 2 coins min
        //     4-5 => -1
        // amount = 5 => 1 coins
        //     5-1=> table[4] + 1 = 3 coins
        //     5-3=> table[2] + 1 = 2 coins
        //     5-5=> table[0] + 1 = 1 coin  min
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{1,2,5},10)); // 2
        System.out.println(countMinimumCoinsRequiredToReachTargetRecursive(new int[]{2},3)); // -1
    }
}
