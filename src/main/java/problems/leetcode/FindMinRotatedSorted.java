package problems.leetcode;

/**
 * Created by sandesh on 6/8/22
 */
//Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinRotatedSorted {
  public static void main(String[] args) {
    int[] arr = {4,5,6,7,0,1,2};
    System.out.println(findMin(arr));
  }
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    while (left < right){
      int mid = left + (right - left) / 2;
      if(nums[mid] < nums[mid - 1])
        return nums[mid];

      else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) //left side is sorted; move towards unsorted side i.e, right
        left = mid + 1;
      else //move left
        right = mid - 1;
    }

    return nums[left];
  }
}
