package interview.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//make time complexity better than O(N)
public class TwoSum2 {
    public static void main(String[] args){
        int[] arr = {2, 4, 5, 7}; //sorted array
        TwoSum2 twoSum2 = new TwoSum2();
        for(List<Integer> pair : twoSum2.sumPair(arr, 9)){
            if(pair.size() == 2)
                System.out.println(pair.get(0) + " " + pair.get(1));
        }
        /**
         * setup:
         * test1: test against negative integers
         * test2: utils func also
         * */

    }
    // 2 4 5 7  ;; target= 9
    public List<List<Integer>> sumPair(int[] arr, int target){
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            boolean found = false;
            int diff = target-arr[i];
            if(diff > arr[i])
                found = binarySearch(arr, i+1, arr.length, diff);
            else
                found = binarySearch(arr, 0, i-1, diff);

            if(found)
                pairs.add(Arrays.asList(arr[i], diff));
        }
        return pairs;
    }

    public boolean binarySearch(int[] arr, int low, int high, int diff){
        if(diff > 0){
            int mid = (low + high) / 2;
            if(arr[mid] == diff)
                return true;
            if(arr[mid] > diff)
                return binarySearch(arr, low, mid - 1, diff);
            return binarySearch(arr, mid + 1, high, diff);
        }else
            return false;
    }
}
