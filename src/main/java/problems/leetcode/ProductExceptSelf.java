package problems.leetcode;

import problems.utils.Helper;

/**
 * Created by sandesh on 6/7/22
 */
//Problem: https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    int[] result = productExceptSelf(arr);
    Helper.printArray(result);
  }

  //T O(N) | S O(1)
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    result[0] = 1;
    for(int i = 1; i < n; i++)
      result[i] = result[i-1] * nums[i-1];

    int right = 1;
    for(int i = n-1; i >= 0; i--){
      result[i] = result[i] * right;
      right = right * nums[i];
    }

    return result;
  }


  //T O(N) | S O(N)
  public static int[] productExceptSelf_1(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];

    //left[i] = product of all elems from 0 to i-1 in nums
    left[0] = 1;
    for(int i = 1; i < n; i++)
      left[i] = left[i-1] * nums[i-1];

    //right[i] = product of all elems from i+1 to n-1 in nums
    right[n-1] = 1;
    for(int i = n-2; i >= 0; i--)
      right[i] = right[i+1] * nums[i+1];

    //multiply between left and right indicates (0 to i-1) * (i+1 to n-1)
    int[] result = new int[n];
    for(int i = 0; i < n; i++)
      result[i] = left[i] * right[i];

    return result;
  }
}
