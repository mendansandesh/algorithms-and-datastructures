package problems.leetcode;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 01/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/rotate-image/
// Level: Medium
// TimeComplexity:  O(N^2)
// SpaceComplexity: O(1)
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = Helper.initializeArrayOfGivenSize(3, 3, false);
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        //get transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){ //j = i because we shouldn't overwrite previously swapped values
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse the row
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
