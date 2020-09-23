package problems.dynamicprogramming;

/**
 * @author sandesh.mendan on 23/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Level: Medium
// TimeComplexity: O(N x W) : N=numOfItems; W=capacity
// SpaceComplexity: O(N x W) : 2D matrix
// Formula: dp[i][j] = Max( V[i-1][j] , V[i-1][W - Wi] + P[i] )
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] profits = { 1,2,5,6 };
        int[] weights = { 2,3,4,5 };
        knapsack(profits, weights, 8);
    }
    public static void knapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1]; //r = numOfItems+1; c = capacity+1
        for (int i = 1; i < dp.length; i++) { //number of items
            for (int j = 1; j < dp[0].length; j++) {  //intermediate weights (capacity)
                if (weights[i - 1] > j)    //weight of item under consideration > intermediate capacity of knapsack
                    dp[i][j] = dp[i - 1][j];  //copy previous row value
                else
                    dp[i][j] = Math.max(dp[i - 1][j], //previous row value
                            dp[i - 1][j - weights[i - 1]] + profits[i - 1]);  //dp[prevRow][intermediateCapacity - currItemsWeight] + currItemProfit
            }
        }

        for (int i = dp.length-1; i > 0;) { //number of items
            for (int j = dp[0].length-1; j > 0;) {  //intermediate weights (capacity)
                if(i < 1)
                    break;
                if(dp[i][j] == dp[i-1][j]) { //if same profitValue present in prevRow indicates its copied from there so dont incl currItem
                    System.out.println("item" + i + " :" + "0");
                    i--;
                }
                else {
                    System.out.println("item" + i + " :" + "1");
                    j = dp[i][j] - profits[i-1] + 1;
                    i--;
                }
            }
        }
    }
}
