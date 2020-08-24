package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandesh.mendan on 21/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/pascals-triangle/
// TimeComplexity:  O(N ^ 2)
// SpaceComplexity: O(1)
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = createPascalTriangle(5);
        for (List<Integer> llist : pascalTriangle) {
            for (int i : llist)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> createPascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            while (rows.size() < i + 1){
                if(rows.isEmpty() || rows.size() == i)
                    rows.add(1);
                else {
                    int prevRows2NumSum = result.get(i - 1).get(rows.size()) + result.get(i - 1).get(rows.size() - 1);
                    rows.add(prevRows2NumSum);
                }
            }
            result.add(rows);
        }
        return result;
    }
}