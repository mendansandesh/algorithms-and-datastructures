package problems.leetcode;

import java.util.Stack;

/**
 * @author sandesh.mendan on 10/01/21
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Level: Hard
// TimeComplexity: O(N)
// SpaceComplexity: O(N)
public class MaxHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2, 3, 1};//{1, 2, 4};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea = -1;
        int area;
        int top;
        int i;

        Stack<Integer> stack = new Stack<>();
        for(i = 0; i < heights.length;){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                top = stack.pop();
                area = calcArea(i, top, stack, heights);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.isEmpty()){
            top = stack.pop();
            area = calcArea(i, top, stack, heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private static int calcArea(int i, int top, Stack<Integer> stack, int[] heights) {
        if(stack.isEmpty())
            return heights[top] * i;
        else
            return heights[top] * (i - stack.peek() - 1);
    }

}
