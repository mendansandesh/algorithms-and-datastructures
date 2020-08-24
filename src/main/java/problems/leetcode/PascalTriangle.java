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
        List<List<Integer>> rows = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            while (row.size() < i + 1){
                if(row.isEmpty() || row.size() == i) //first and last elem in each row
                    row.add(1);
                else {
                    int prevRows2NumSum = rows.get(i - 1).get(row.size()) + rows.get(i - 1).get(row.size() - 1);
                    row.add(prevRows2NumSum);
                }
            }
            rows.add(row);
        }
        return rows;
    }
}