package problems.leetcode;

import problems.utils.Helper;

import java.util.*;

/**
 * @author sandesh.mendan on 14/09/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/3sum/
// Level: Medium
// TimeComplexity:  O(N2)
// SpaceComplexity: O()
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> uniqueTriplets = threeSum(arr, 0);
        for (List triplets : uniqueTriplets){
            System.out.println(triplets);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){ //to check we dont take same num twice
                int sum = target - nums[i];
                int low = i+1;
                int high = nums.length-1;
                while (low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
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
            }
        }
        return res;
    }
}
