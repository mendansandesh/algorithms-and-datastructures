package problems.dynamicprogramming;

/**
 * @author sandesh.mendan on 16/09/20
 * @project algorithms-and-datastructures
 */
// Problem: return Nth fibonacci number
// DynamicProgramming strategy: TopDown and BottomUp approach
// TimeComplexity: O(1.6)^N
// SpaceComplexity: extra stack
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib_topDown(50));
        System.out.println(fib_bottomUp(50));
    }

    private static int fib_topDown(int n){
        int[] dp = new int[n+1];
        return fib_topDown(dp, n);
    }

    private static int fib_topDown(int[] dp, int n){
        if(n <= 0)
            return -1;
        if(n == 1 || n == 2)
            return 1;
        if(dp[n] == 0)
            dp[n] = fib_topDown(dp, n-1) + fib_topDown(dp, n-2);

        return dp[n];
    }

    private static int fib_bottomUp(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
}