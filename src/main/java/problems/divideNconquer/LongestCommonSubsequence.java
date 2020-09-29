package problems.divideNconquer;

/**
 * @author sandesh.mendan on 28/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/longest-common-subsequence/
// Level: Medium
// TimeComplexity: O(2^N) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
// SpaceComplexity:
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("elephant", "eretpat"));
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        return longestCommonSubsequence(s1, 0, s2, 0);
    }

    private static int longestCommonSubsequence(String s1, int i1, String s2, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
            return 0;
        int case1 = 0;
        if(s1.charAt(i1) == s2.charAt(i2))
            case1 = 1 + longestCommonSubsequence(s1, i1 + 1, s2, i2 + 1);
        int case2a = longestCommonSubsequence(s1, i1, s2, i2 + 1);
        int case2b = longestCommonSubsequence(s1, i1 + 1, s2, i2);
        return Math.max(case1, Math.max(case2a, case2b));
    }
}
