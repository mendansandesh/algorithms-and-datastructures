package problems.utils;

import java.util.List;

/**
 * @author sandesh.mendan on 11/08/20
 * @project algorithms-and-datastructures
 */
public class Helper {
    public static int[][] initializeArrayOfGivenSize(int R, int C, boolean zeroArray) {
        int[][] a = new int[R][C];
        if(zeroArray){
            System.out.println("Initializing array... ");
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    a[i][j] = 0;
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------");
        }else {
            int c=0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    a[i][j] = ++c;
                }
            }
        }
        return a;
    }

    public static<T> void printArray(T[] arr){
        for(T a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static <T> void printArray(List<T> arr){
        for(T a: arr)
            System.out.print(a + " ");
    }

    public static void printArray(int[] arr){
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }
}
