package sorting;

import java.util.Arrays;

/**
 * @author Sandesh Mendan on 04/07/20
 * @project algorithms-and-datastructures
 */
public class MergeSort {
    public static void main(String[] args){
        int[] arr = { 10, 5, 30, 15, 50, 6 };
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        //declare 2 sub arrays
        int sizeOfLeftSubArray  = mid - left + 1;
        int sizeOfRightSubArray = right-mid;
        int[] leftSubArray  = new int[sizeOfLeftSubArray];
        int[] rightSubArray = new int[sizeOfRightSubArray];

        //copy elements from actual array to each sub array based on their indices
        for(int i = 0; i < sizeOfLeftSubArray; i++)
            leftSubArray[i] = arr[left+i];
        for(int i = 0; i < sizeOfRightSubArray; i++)
            rightSubArray[i] = arr[mid+1+i];

        //merge leftSubArray and rightSubArray
        int i = 0, j = 0, k = left;
        while (i < sizeOfLeftSubArray && j < sizeOfRightSubArray)
            if(leftSubArray[i] <= rightSubArray[j])
                arr[k++] = leftSubArray[i++];
            else
                arr[k++] = rightSubArray[j++];

        //copy remaining elements from both the arrays if any
        while (i < sizeOfLeftSubArray)
            arr[k++] = leftSubArray[i++];

        while(j < sizeOfRightSubArray)
            arr[k++] = rightSubArray[j++];
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
