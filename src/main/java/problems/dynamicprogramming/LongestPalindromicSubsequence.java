package problems.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sandesh.mendan on 30/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/longest-palindromic-subsequence/
// Level: Medium
// TimeComplexity: O(N ^ 2)
// SpaceComplexity: O(M x N) - 2D matrix
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //System.out.println(lpsTopDown("amawqdxaym"));
        System.out.println(lpsBottomUp("amawqdxaym"));
    }
    private static int lpsTopDown(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for(int i = 0; i < str.length(); i++)
            Arrays.fill(dp[i], -1);
        return lpsTopDown(dp, str, 0, str.length()-1);
    }
    private static int lpsTopDown(int[][] dp, String str, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;
        if(dp[startIndex][endIndex] == -1){
            int case1 = 0;
            if (str.charAt(startIndex) == str.charAt(endIndex))
                case1 = 2 + lpsTopDown(dp, str, startIndex + 1, endIndex - 1);
            int case2a = lpsTopDown(dp, str, startIndex, endIndex - 1);
            int case2b = lpsTopDown(dp, str, startIndex + 1, endIndex);
            dp[startIndex][endIndex] = Math.max(case1, Math.max(case2a, case2b));;
        }
        return dp[startIndex][endIndex];
    }
    private static int lpsBottomUp(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for(int col = 0; col < str.length(); col++){
            for(int row = str.length()-1; row >= 0; row--){
                if(row > col)
                    dp[row][col] = 0;
                else if(row == col)
                    dp[row][col] = 1;
                else {
                    if(str.charAt(row) == str.charAt(col))
                        dp[row][col] = Math.max(2 + dp[row+1][col-1], Math.max(dp[row+1][col], dp[row][col-1]));
                    else
                        dp[row][col] = Math.max(dp[row+1][col], dp[row][col-1]);
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
