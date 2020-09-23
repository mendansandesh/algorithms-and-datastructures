package problems.divideNconquer;

/**
 * @author sandesh.mendan on 23/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Level: Medium
// TimeComplexity: O(2 ^ N)
// SpaceComplexity: O(1)
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] profits = { 31, 26, 72, 17 };
        int[] weights = { 3, 1, 5, 2 };
        int maxProfit = knapsack(profits, weights, 7);
        System.out.println(maxProfit);
    }
    public static int knapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits, weights, capacity, 0);
    }

    private static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currIndex) {
        if(capacity <= 0 || currIndex < 0 || currIndex >= weights.length)
            return 0;

        int profit = 0;
        if(weights[currIndex] <= capacity){
            int withCurrItem = profits[currIndex] + knapsackRecursive(profits, weights, capacity-weights[currIndex], currIndex+1);
            int withoutCurrItem = knapsackRecursive(profits, weights, capacity, currIndex+1);
            profit = Math.max(withCurrItem, withoutCurrItem);
        }
        return profit;
    }
}
