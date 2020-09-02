package problems.leetcode;

/**
 * @author sandesh.mendan on 01/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/powx-n/
// Level: Medium
// TimeComplexity:  O(N)
// SpaceComplexity: O(1)
public class XpowerN {
    public static void main(String[] args){
        System.out.println(myPow(34.00515, -3));
    }

    public static double myPow(double x, int n) {
        double res;
        if(n == 0)
            return 1;
        res = myPow(x, n/2);
        if(n % 2 == 0)
            return res * res;
        else {
            if(n > 0)
                return x * res * res;
            else
                return (res * res)/x;
        }
    }
}
