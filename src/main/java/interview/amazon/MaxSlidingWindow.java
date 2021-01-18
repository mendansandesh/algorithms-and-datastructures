package interview.amazon;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sandesh.mendan on 18/01/21
 * @project algorithms-and-datastructures
 */
/*
Problem: https://leetcode.com/problems/sliding-window-maximum/
Time: O(N)
Space: Deque O(k) and result array O(N - k + 1)
 */
public class MaxSlidingWindow {
    public static void main(String[] args){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] maxSlidingWindow = new int[nums.length - k + 1];
        int i;
        int j = 0;
        for(i = 0; i < k; ++i){
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        for(i = k; i < nums.length; ++i){
            maxSlidingWindow[j++] = nums[queue.peek()];
            while(!queue.isEmpty() && queue.peek() <= i - k)
                queue.removeFirst();
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        maxSlidingWindow[j++] = nums[queue.peek()];
        return maxSlidingWindow;
    }
}
