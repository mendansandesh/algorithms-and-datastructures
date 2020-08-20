package problems.leetcode;


import problems.utils.Helper;

/**
 * @author sandesh.mendan on 18/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/set-matrix-zeroes/
// TimeComplexity:  O(2 x (NxM))
// SpaceComplexity: O(1)
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        //from index [1,1], if any zero set corresponding 1st row and 1st col index to 0
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(r == 0 && matrix[r][c] == 0) //check if 1st row has any zero
                    firstRowHasZero = true;
                if(c == 0 && matrix[r][c] == 0)  //check if 1st col has any zero
                    firstColHasZero = true;
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        //from index [1, 1], if 1st col has 0, if its corresponding row to 0
        for(int r = 1; r < matrix.length; r++)
            if(matrix[r][0] == 0)
                for(int c = 1; c < matrix[0].length; c++)
                    matrix[r][c] = 0;

        //from index [1, 1], if 1st row has 0, if its corresponding col to 0
        for(int c = 1; c < matrix[0].length; c++)
            if(matrix[0][c] == 0)
                for(int r = 1; r < matrix.length; r++)
                    matrix[r][c] = 0;

        if(firstRowHasZero) //then set first row to 0
            for(int c = 0; c < matrix[0].length; c++)
                matrix[0][c] = 0;

        if(firstColHasZero) //then set first col to 0
            for(int r = 0; r < matrix.length; r++)
                matrix[r][0] = 0;
        //Helper.print2DArray(matrix);
    }
}
