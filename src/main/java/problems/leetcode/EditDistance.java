package problems.leetcode;

/**
 * @author sandesh.mendan on 22/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/edit-distance/
// Level: Hard
// TimeComplexity: O(m x n)
// SpaceComplexity: O(m x n)
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(findMinOperations("table", "tbres"));
        System.out.println(findMinOperations("azced", "abcdef"));
    }

    private static int findMinOperations(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i < dp.length; i++)
            dp[i][0] = i;
        for(int i = 1; i < dp[0].length; i++)
            dp[0][i] = i;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
