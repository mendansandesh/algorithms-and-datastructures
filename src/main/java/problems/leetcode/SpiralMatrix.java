package problems.leetcode;

import problems.utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sandesh.mendan on 13/08/20
 * @project algorithms-and-datastructures
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = Helper.initializeArrayOfGivenSize(3, 4, false);
        Helper.printArray(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return list;
        int R = matrix.length;
        int C = matrix[0].length;
        int i, k = 0, l = 0, lr = R-1, lc = C-1;
        while (k <= lr && l <= lc){
            for(i = l; i <= lc; i++)
                list.add(matrix[k][i]);
            k++;
            for(i = k; i <= lr; i++)
                list.add(matrix[i][lc]);
            lc--;
            if(k <= lr) {
                for (i = lc; i >= l; i--)
                    list.add(matrix[lr][i]);
                lr--;
            }
            if(l <= lc) {
                for (i = lr; i >= k; i--)
                    list.add(matrix[i][l]);
                l++;
            }
        }
        return list;
    }
}
