package problems.leetcode;


import problems.utils.Helper;

/**
 * @author sandesh.mendan on 12/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0, 2, 1, 1};
        sortColors(arr);
        Helper.printArray(arr);
    }

    private static void sortColors(int[] arr) {
        int low = 0; //all elem left side of low should be 0
        int mid = 0;
        int high = arr.length-1; //all elem right side of high should be 2

        while (mid < high){
            switch (arr[mid]){
                case 0 :
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    public static int[] swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }
}
