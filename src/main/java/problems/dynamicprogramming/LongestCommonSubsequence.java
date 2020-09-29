package problems.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sandesh.mendan on 28/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/longest-common-subsequence/
// Level: Medium
// TimeComplexity: O(M x N) which is much better than the worst-case time
// SpaceComplexity: O(M x N) - 2D matrix
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //System.out.println(lcsTopDown("elephant", "eretpat"));
        //System.out.println(lcsBottomUp("elephant", "eretpat"));
        System.out.println(lcsBottomUp2("elephant", "eretpat"));
    }

    private static int lcsTopDown(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++)
            Arrays.fill(dp[i], -1); //initialize all cells to -1 except for last row and col
        return lcsTopDown(dp, s1, 0, s2, 0); //start from (0, 0)
    }

    private static int lcsTopDown(int[][] dp, String s1, int i1, String s2, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
            return 0;
        if(dp[i1][i2] == -1){ // indicates cell not computed
            int case1 = 0;
            if(s1.charAt(i1) == s2.charAt(i2)) //if same chars, 1+check next char at both strings
                case1 = 1 + lcsTopDown(dp, s1, i1 + 1, s2, i2 + 1);
            int case2a = lcsTopDown(dp, s1, i1, s2, i2 + 1); //check same char in s1, next char in s2
            int case2b = lcsTopDown(dp, s1, i1 + 1, s2, i2); //check same char in s2, next char in s1
            dp[i1][i2] = Math.max(case1, Math.max(case2a, case2b)); //fill dp position by max among all 3
        }
        return dp[i1][i2];
    }

    private static int lcsBottomUp(String s1, String s2) {
        //same logic as above;
        //-1 initialization not required, since we compute and fill bottomup (last char to first);
        //we can also compute and fill from first to last; considering index (1, 1) is our starting computing position, when first row and col initialized to 0
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = s1.length(); i >= 1; i--){
            for(int j = s2.length(); j >= 1; j--){
                int case1 = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    case1 = Math.max(1 + dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                int case2 = Math.max(dp[i][j-1], dp[i-1][j]);
                dp[i-1][j-1] = Math.max(case1, case2);
            }
        }
        return dp[0][0];
    }

    //TusharRoys: if same chars: 1+dp[i-1][j-1] else Max(dp[i][j-1], dp[i-1][j])
    private static int lcsBottomUp2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        //compute and fill from start to end of string
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                if(s1.charAt(i-1) != s2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
