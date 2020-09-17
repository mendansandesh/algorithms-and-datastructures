package problems.leetcode;

import java.util.Arrays;

/**
 * @author sandesh.mendan on 17/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/coin-change/
// DynamicProgramming bottom up approach
// Level: Medium
// TimeComplexity:  O(A x C) where A = amount to make change for; C = total coins provided //same time for topDown as well
// SpaceComplexity: O(A)
public class CoinChange {
    public static void main(String[] args) {
        //int[] coins = {1, 2, 5}; //11
        int[] coins = {186, 419, 83, 408}; //6249
        System.out.println(coinChange(coins, 6249));
    }

    private static int coinChange(int[] coins, int amount) {
        //create array to store least denominations required for each intermediateAmount from 1 to amount
        //array size [amount+1] (valid amount starts from 1)
        int[] dp = new int[amount+1];

        //initialize to some value greater than amount
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // need 0 denominations of coins array to make 0 amount

        //start computing and fill for 1 to amount
        for(int smallerAmount = 1; smallerAmount <= amount; smallerAmount++) {
            //try to compute using each coins to make the smallerAmount
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= smallerAmount) {
                    //minDenomination for smallerAmount = min(a, b)
                    //a = one currCoin + previously computed minDenomination(remainingAmount = smallerAmount-currCoin)
                    //b = previously computed minDenomination(smallerAmount)
                    dp[smallerAmount] = Math.min(1 + dp[smallerAmount - coins[j]], dp[smallerAmount]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
