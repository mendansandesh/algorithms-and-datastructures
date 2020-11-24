package problems.leetcode;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 24/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/move-zeroes/
// Time: O(N)
// Space: O(1)
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0, 2, 1, 1};
        moveZeroes(arr);
        Helper.printArray(arr);
    }

    private static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for(int i = nonZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }

}
