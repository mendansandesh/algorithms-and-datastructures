package problems.hackerrank;

/**
 * @author sandesh.mendan on 30/08/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.hackerrank.com/challenges/ctci-merge-sort/problem
// TimeComplexity:  O(N log N)
// SpaceComplexity: O(N)
// 6/16 test cases failed
public class InversionArrayCount {
    public static void main(String[] args){
        int[] arr = { 8, 4, 2, 1 };
        System.out.println(mergeSort(arr, 0, arr.length-1)); // note: same merge sort code with invCount tracker
    }

    private static long mergeSort(int[] arr, int left, int right) {
        int invCount = 0;
        if (left < right){
            int mid = (left + right) / 2;
            invCount += mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid+1, right);
            invCount += merge(arr, left, mid, right);
        }
        return invCount;
    }

    private static int merge(int[] arr, int left, int mid, int right){
        int invCount = 0;
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
            else {
                arr[k++] = rightSubArray[j++];
                invCount += (mid + 1) - (left + i); // count from i till mid, as left subarray is sorted
            }

        //copy remaining elements from both the arrays if any
        while (i < sizeOfLeftSubArray)
            arr[k++] = leftSubArray[i++];

        while(j < sizeOfRightSubArray)
            arr[k++] = rightSubArray[j++];

        return invCount;
    }
}
