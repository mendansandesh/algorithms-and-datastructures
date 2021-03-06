package problems.leetcode;

/**
 * @author sandesh.mendan on 10/08/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/find-the-duplicate-number/
// Time: O(N)
// Space: O(1)
public class FirstDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(getDuplicateNumber(arr));
    }

    private static int firstDuplicate(int[] arr) {
        //as array has only numbers from 1 to N;
        //take abs(arr[i]) - 1 as index; just negate the elem at that index;
        //if elem is repeated on the 2nd time, using above method we can notice the number is already -ve indicating the elem is duplicate;
        //note: use abs() value carefully even while returning
        for(int i = 0; i < arr.length; i++){
            if(arr[Math.abs(arr[i]) - 1] < 0)
                return Math.abs(arr[i]);
            else
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }
        return -1;
    }

    //other ways to do using HashSet to check if number s already present

    private static int getDuplicateNumber(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow != fast);
        fast = arr[0];
        while (slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
