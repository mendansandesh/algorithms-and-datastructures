package problems.leetcode;

/**
 * Created by sandesh on 6/8/22
 */
//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchElemRotatedSorted {
  public static void main(String[] args) {
    int[] arr = {4,5,6,7,0,1,2};
    System.out.println(search(arr, 0));
  }
  public static int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length-1);
  }
  public static int search(int[] nums, int target, int low, int high) {
    if (low > high)
      return -1;

    int mid = low + (high - low) / 2;
    if(nums[mid] == target)
      return mid;

    //check if left half is sorted
    if(nums[low] <= nums[mid]){
      //check if target is present in left half if so, recursively call to find index
      if(nums[low] <= target && target < nums[mid])
        return search(nums, target, low, mid-1);
      else
        //search in right half
        return search(nums, target, mid+1, high);
    }else {
      if(nums[mid] < target && target <= nums[high])
        return search(nums, target, mid+1, high);
      else
        return search(nums, target, low, mid-1);
    }
  }
}
