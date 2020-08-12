package problems.leetcode;

/**
 * @author sandesh.mendan on 10/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(getDuplicateNumber(arr));
    }

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
