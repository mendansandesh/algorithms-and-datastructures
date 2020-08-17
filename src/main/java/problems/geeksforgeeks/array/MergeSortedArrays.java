package problems.geeksforgeeks.array;

import problems.utils.Helper;

import java.util.Arrays;

/**
 * @author sandesh.mendan on 17/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
// TimeComplexity:  O(NxM)
// SpaceComplexity: O(1)
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        merge(arr1, arr1.length, arr2, arr2.length);
        Helper.printArray(arr1);
        Helper.printArray(arr2);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < m; i++){
            if(nums2[0] < nums1[i]) {
                swap(nums1, i, nums2); //nums2 swapping position is always 0
                if(nums2[0] > nums2[1]) //after swap make sure nums2 is sorted; nums1 will be already sorted;
                    Arrays.sort(nums2);
            }
        }
    }

    private static void swap(int[] nums1, int num1ArrayPos, int[] nums2) {
        int temp = nums1[num1ArrayPos];
        nums1[num1ArrayPos] = nums2[0];
        nums2[0] = temp;
    }
}
