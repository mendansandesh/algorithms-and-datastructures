package problems.leetcode;

/**
 * @author sandesh.mendan on 02/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/factorial-trailing-zeroes/
// Level: Easy
// TimeComplexity:  O(LOG N)
// SpaceComplexity: O(1)
public class CountTrailingZeroes {
    public static void main(String[] args){
        System.out.println(trailingZeroes(19));
    }
    public static int trailingZeroes(int n) {
        int count = 0;

        while(n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
