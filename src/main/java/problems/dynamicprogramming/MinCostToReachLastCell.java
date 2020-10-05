package problems.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sandesh.mendan on 05/10/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/min-cost-path-dp-6/
// Level: Medium
// TimeComplexity: O(M x N)
// SpaceComplexity: O(M x N) - 2D matrix
public class MinCostToReachLastCell {
    public static void main(String[] args) {
        int[][] array =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };
        System.out.println(findMinCostTopDown(array, array.length-1, array[0].length-1));
    }
    private static int findMinCostTopDown(int[][] cost, int row, int col) {
        int[][] res = new int[row+1][col+1];
        for(int i = 0; i < res.length; i++)
            Arrays.fill(res[i], -1);
        return findMinCostTopDown(res, cost, row, col);
    }

    private static int findMinCostTopDown(int[][] res, int[][] cost, int row, int col) {
        if(row == -1 || col == -1)
            return Integer.MAX_VALUE;
        if(row == 0 && col == 0)
            return cost[0][0];
        if(res[row][col] == -1){
            res[row][col] = cost[row][col] + Math.min(findMinCostTopDown(cost, row-1, col), findMinCostTopDown(cost, row, col-1));
        }
        return res[res.length-1][res[0].length-1];
    }

    private static int findMinCostBottomUp(int[][] cost, int row, int col) {
        int[][] dp = new int[cost.length+1][cost[0].length+1];
        for(int i = 0; i <= dp.length; i++) {  //Initialize default value
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= row; i++) {  //Initialize default value
            dp[i][0] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= cost.length; i++){
            for(int j = 1; j <= cost[0].length; j++){
                dp[i][j] = cost[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
