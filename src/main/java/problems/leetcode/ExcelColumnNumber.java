package problems.leetcode;

import java.util.List;

/**
 * @author sandesh.mendan on 24/08/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/excel-sheet-column-number/
// TimeComplexity:  O(N)
// SpaceComplexity: O(N)
public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("CDA"));
    }
    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int charsPosition = chars.length - 1;
        for(int i = 0; i < chars.length; i++){
            //from left to right; char's position times 26 * char's value
            result += Math.pow(26, charsPosition) * (chars[i] - 'A' + 1);
            charsPosition--;
        }
        return result;
    }
}
