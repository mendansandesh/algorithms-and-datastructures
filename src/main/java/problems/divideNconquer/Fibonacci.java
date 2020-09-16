package problems.divideNconquer;

/**
 * @author sandesh.mendan on 16/09/20
 * @project algorithms-and-datastructures
 */
// Problem: return Nth fibonacci number
// Divide and conquer strategy: simple recursion
// TimeComplexity: O(1.6)^N
// SpaceComplexity: extra stack
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int n){
        if(n <= 0)
            return -1;
        if(n == 1 || n == 2)
            return 1;
        return fib(n-1) + fib(n-2);
    }
}
