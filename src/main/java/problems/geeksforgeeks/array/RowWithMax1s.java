package problems.geeksforgeeks.array;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 30/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
// Time: O(N + M + Log(M) ==> O(N + M)
// Space: O(1)
public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 0,0,0,0,1,1 }, //max1sIndex = 4
                        { 0,0,0,1,1,1 }, //max1sIndex = 3
                        { 0,0,0,0,1,1 }, //max1sIndex = 4
                        { 0,0,1,1,1,1 },
                        { 0,0,0,1,1,1 }
                };
        System.out.println(first(matrix));
    }

    // can also perform column wise search for better result
    private static int first(int[][] matrix){
        int maxRow = -1;
        int max1sIndex = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            int currRowMax1sIndex = indexOfFirstOccurrenceOfOne(matrix[i], 0, matrix[i].length-1);
            if(currRowMax1sIndex != -1 && currRowMax1sIndex < max1sIndex){ // -1 check because indexOfFirstOccurrenceOfOne return -1 if no 1s found
                maxRow = i;
            }
        }
        return maxRow;
    }

    private static int indexOfFirstOccurrenceOfOne(int[] array, int low, int high){

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(array[mid] == 1 && (mid == 0 || array[mid - 1] == 0))
                return mid;
            else if(array[mid] == 0)
                return indexOfFirstOccurrenceOfOne(array, mid+1, high);
            else
                return indexOfFirstOccurrenceOfOne(array, low, mid-1);
        }
        return -1;
    }
}
