package problems.leetcode;

import problems.utils.Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandesh.mendan on 24/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, -5};
        int[] indices = twoSum(arr, -8);
        Helper.printArray(indices);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))    //if difference exists
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i); //store the difference -> index
        }
        return new int[]{-1, -1};
    }
}
