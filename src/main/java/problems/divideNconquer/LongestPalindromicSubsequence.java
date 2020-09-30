package problems.divideNconquer;

/**
 * @author sandesh.mendan on 30/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/longest-palindromic-subsequence/
// Level: Medium
// TimeComplexity:
// SpaceComplexity:
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("amawqdxaym"));
    }

    private static int longestPalindromicSubsequence(String str) {
        return longestPalindromicSubsequence(str, 0, str.length()-1);
    }

    private static int longestPalindromicSubsequence(String str, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;
        int case1 = 0;
        if(str.charAt(startIndex) == str.charAt(endIndex))
            case1 = 2 + longestPalindromicSubsequence(str, startIndex+1, endIndex-1);
        int case2a = longestPalindromicSubsequence(str, startIndex, endIndex-1);
        int case2b = longestPalindromicSubsequence(str, startIndex+1, endIndex);
        return Math.max(case1, Math.max(case2a, case2b));
    }

}
