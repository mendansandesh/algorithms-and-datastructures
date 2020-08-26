package problems.leetcode;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 26/08/20
 * @project algorithms-and-datastructures
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 3 , 2};
        nextPermutation(arr);
        Helper.printArray(arr);
    }
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        //from end, find index such that a[index] < a[index+1]
        int decreaseIndex = -1;
        for (int i = nums.length-2; i >=0 ; i--){
            if(nums[i] < nums[i+1]){
                decreaseIndex = i;
                break;
            }
        }
        //from end, find i such that a[i] > a[index] and swap them
        if(decreaseIndex >= 0){
            for (int i = nums.length-1; i >= 0 ; i--){
                if(nums[i] > nums[decreaseIndex]) {
                    Helper.swap(nums, decreaseIndex, i);
                    break;
                }
            }
        }
        //from reverse all elements from [index+1] position till end
        reverse(nums, decreaseIndex+1, nums.length-1);
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) Helper.swap(nums, i++, j--);
    }
}
