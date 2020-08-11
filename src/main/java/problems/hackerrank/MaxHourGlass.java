package problems.hackerrank;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 11/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://www.hackerrank.com/challenges/2d-array/problem
public class MaxHourGlass {
    public static void main(String[] args) {
        int[][] arr = Helper.initializeArrayOfGivenSize(6, 6, false);
        System.out.println(maxOfHourGlass(arr)); // 2/9 test cases failed
    }

    private static int maxOfHourGlass(int[][] arr) {
        int maxSum = 0;
        //outer matrix: its a result matrix of 4x4
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                int sumInner = 0;
                //inner matrix of 3x3
                for(int ii = i; ii < i+3; ii++){
                    int c = 0;
                    for(int jj = j; jj < j+3; jj++){
                        if(ii == i+1){
                            if(c == 1){
                                sumInner += arr[ii][jj];
                                System.out.print(arr[ii][jj] + " ");
                            }else
                                System.out.print(" ");
                            c++;
                        }else {
                            sumInner += arr[ii][jj];
                            System.out.print(arr[ii][jj] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.print(" ");// 0 1 2 'this space' 1 2 3
                maxSum = Math.max(maxSum, sumInner);
            }
            System.out.println();
        }
        return maxSum;
    }
}
