package problems.divideNconquer;

/**
 * @author sandesh.mendan on 05/10/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/min-cost-path-dp-6/
// Level: Medium
// TimeComplexity: O(2^N)
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
        System.out.println(findMinCost(array, array.length-1, array[0].length-1));
    }
    private static int findMinCost(int[][] cost, int row, int col) {
        if(row == -1 || col == -1)
            return Integer.MAX_VALUE;
        if(row == 0 && col == 0)
            return cost[0][0];

        return cost[row][col] + Math.min(findMinCost(cost, row-1, col), findMinCost(cost, row, col-1));
    }
}
