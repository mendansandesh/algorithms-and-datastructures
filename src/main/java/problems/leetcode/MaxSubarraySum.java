package problems.leetcode;

/**
 * @author sandesh.mendan on 27/08/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/maximum-subarray/
// TimeComplexity:  O(N)
// SpaceComplexity: O(1)
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubarraySum(arr));
    }

    public static int maxSubarraySum(int[] nums) {
        //Kadane's algorithm
        int sum = 0;
        int maxSum = nums[0];   //initialize to first elem
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > maxSum)    //if sum is greater than maxSum then update maxSum to sum
                maxSum = sum;
            if(sum < 0)         //if sum is negative, then reset sum to 0 because we want to maximize subarray sum;
                sum = 0;        //...considering negative number will reduce the sum
        }
        return maxSum;
    }
}
