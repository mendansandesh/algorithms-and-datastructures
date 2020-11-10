package problems.dynamicprogramming;

/**
 * @author sandesh.mendan on 30/10/20
 * @project algorithms-and-datastructures
 */
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3513/
Longest Increasing Subsequence:
Given an integer array nums, return the number of longest increasing subsequences.

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 */
public class Lis {
    public static void main(String[] args) {
        //int[] a = {5, 4, 7};
        int[] a = {1,3,5, 4, 7};
        //System.out.println(maxLength(a, 0, Integer.MIN_VALUE));
        System.out.println(maxLength2(a));
    }

    public static int maxLength2(int[] a) {
        int finalCount = 0;
        int[][] dp = new int[a.length + 1][a.length + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int includingCurIndex = 0;

                if (a[i-1] > a[j-1]) {
                    includingCurIndex = 1 + dp[i][j-1];
                }

                int excludingCurIndex = dp[i][j-1];

                dp[i][j] = Math.max(includingCurIndex, excludingCurIndex);
            }
        }
        int maxSubsequenceLength = dp[dp.length-1][dp[0].length-1]; //last elem is max length of increasing subsequence possible
        //need to find how many times above value has repeated in the matrix
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++) {
                /*if(dp[i][j] == maxSubsequenceLength)
                    finalCount++;*/
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return finalCount;
    }

    public static int maxLength(int[] nums, int index, int prevVal) {

        if (index >= nums.length) {
            return 0;
        }

        int includingCurIndex = 0;

        if (nums[index] > prevVal) {
            includingCurIndex = 1 + maxLength(nums, index + 1, nums[index]);
        }

        int excludingCurIndex = maxLength(nums, index + 1, nums[index]);

        return Math.max(includingCurIndex, excludingCurIndex);
    }

}
