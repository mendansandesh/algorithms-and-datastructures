package problems.hackerrank;

import problems.utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sandesh.mendan on 11/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://www.hackerrank.com/challenges/2d-array/problem
public class MaxHourGlass {
    public static void main(String[] args) {
        //int[][] arr = Helper.initializeArrayOfGivenSize(6, 6, false);
        List<List<Integer>> arr = Stream.of(
                Arrays.asList(-9, -9, -9,  1, 1, 1),
                Arrays.asList( 0, -9,  0,  4, 3, 2),
                Arrays.asList(-9, -9, -9,  1, 2, 3),
                Arrays.asList( 0,  0,  8,  6, 6, 0),
                Arrays.asList( 0,  0,  0, -2, 0, 0),
                Arrays.asList( 0,  0,  1,  2, 4, 0)
        ).collect(Collectors.toList());
        System.out.println(maxOfHourGlass(arr)); // 2/9 test cases failed
    }

    private static int maxOfHourGlass(List<List<Integer>> arr) {
        List<Integer> sum = new ArrayList<>();
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                sum.add(arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                                          + arr.get(i+1).get(j+1)
                      + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2));
            }
        }
        return Collections.max(sum);
    }
        /*int maxSum = 0;
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
                                sumInner += arr.get(ii).get(jj);
                                //System.out.print(arr.get(ii).get(jj) + " ");
                            }*//*else
                                System.out.print(" ");*//*
                            c++;
                        }else {
                            sumInner += arr.get(ii).get(jj);
                            //System.out.print(arr.get(ii).get(jj) + " ");
                        }
                    }
                    //System.out.println();
                }
                //System.out.print(" ");// 0 1 2 'this space' 1 2 3
                maxSum = Math.max(maxSum, sumInner);
            }
            //System.out.println();
        }
        return maxSum;
    }*/
}
