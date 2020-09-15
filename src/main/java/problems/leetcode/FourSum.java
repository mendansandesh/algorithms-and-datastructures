package problems.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sandesh.mendan on 15/09/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/4sum/
// Level: Medium
// TimeComplexity:  O(N2)
// SpaceComplexity: O()
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        List<List<Integer>> uniqueQuadruplets = fourSum(arr, 0);
        for (List quadruplets : uniqueQuadruplets)
            System.out.println(quadruplets);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = target - nums[j] - nums[i];
                int low = j+1;
                int high = nums.length-1;
                while (low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        //avoiding duplicate result and set low and high to proper index
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum)
                        high--;
                    else
                        low++;
                }
                while (j+1 < nums.length && nums[j] == nums[j+1]) j++;
            }
            while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}
