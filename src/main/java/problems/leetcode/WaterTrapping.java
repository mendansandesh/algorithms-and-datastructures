package problems.leetcode;

/**
 * @author sandesh.mendan on 04/02/21
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/trapping-rain-water/
// TimeComplexity:  O(N)
// SpaceComplexity: O(1)
public class WaterTrapping {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int leftMax;
        int rightMax;
        int currWaterStorage = 0;
        int n = height.length;
        for(int i = 1; i < n-1; i++){
            leftMax = height[i];
            for(int j = 0; j < i; j++)
                leftMax = Math.max(leftMax, height[j]);

            rightMax = height[i];
            for(int j = i+1; j < n; j++)
                rightMax = Math.max(rightMax, height[j]);

            currWaterStorage += (Math.min(leftMax, rightMax) - height[i]);
        }
        return currWaterStorage;
    }
}
