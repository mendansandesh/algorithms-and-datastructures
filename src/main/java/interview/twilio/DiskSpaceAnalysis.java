package interview.twilio;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sandesh.mendan on 15/10/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
// other reference: https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class DiskSpaceAnalysis {
    public static void main(String[] args){
        int[] arr = {1, 1};
        int m = 2;
        System.out.println(maxMinInSegment(arr, m));
    }

    private static int maxMinInSegment2(int[] arr, int m) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < i+m; j++){
                min = Math.min(min, arr[j]);
            }
            max = Math.max(min, max);
        }
        return max;
    }

    private static int maxMinInSegment(int[] arr, int m) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> minOfEachSegment = new LinkedList<>();
        int i;

        for(i = 0; i < m; ++i){
            while (!queue.isEmpty() && arr[i] <= arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        for(; i < arr.length; ++i){
            minOfEachSegment.add(arr[queue.peek()]);
            while (!queue.isEmpty() && queue.peek() <= i - m)
                queue.removeFirst();
            while (!queue.isEmpty() && arr[i] <= arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        minOfEachSegment.add(arr[queue.peek()]);
        int min = 0;
        for(Integer item : minOfEachSegment){
            if(item > min)
                min = item;
        }
        return min;
    }
}
