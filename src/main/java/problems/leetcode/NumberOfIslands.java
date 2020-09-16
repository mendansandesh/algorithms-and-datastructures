package problems.leetcode;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 16/09/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/number-of-islands/
// Level: Medium
// TimeComplexity:  O(V): no.of nodes = number of elem in 2D array
// SpaceComplexity: O(1)
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                        };
        System.out.println(numIslands(grid));
    }
    private static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
}
