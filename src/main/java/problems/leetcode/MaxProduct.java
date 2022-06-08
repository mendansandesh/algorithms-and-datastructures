package problems.leetcode;

/**
 * Created by sandesh on 6/8/22
 */
//Problem: https://leetcode.com/problems/maximum-product-subarray/
public class MaxProduct {
  public static void main(String[] args) {
    int[] arr = {2,3,-2,4};
    System.out.println(maxProduct(arr));
  }
  public static int maxProduct(int[] nums) {
    if(nums == null || nums.length == 0)
      return 0;

    int max = nums[0];
    int min = nums[0];
    int maxSoFar = Integer.MIN_VALUE;

    for(int i = 1; i < nums.length; i++){
      int temp = max;
      max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
      min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
      maxSoFar = Math.max(maxSoFar, max);
    }

    return maxSoFar;
  }
}
