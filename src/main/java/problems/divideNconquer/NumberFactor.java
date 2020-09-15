package problems.divideNconquer;

/**
 * @author sandesh.mendan on 15/09/20
 * @project algorithms-and-datastructures
 */
// Problem: Given N, count the number of ways to express N as sum of [1, 3, 4]
// Optimal Substructure: as we can break down the problem into similar smaller problem
// TimeComplexity:
// SpaceComplexity:
public class NumberFactor {
    public static void main(String[] args) {
        System.out.println(waysToGetN(5));  //{4,1}, {1,4}, {3,1,1}, {1,3,1}, {1,1,3}, {1,1,1,1}
    }

    private static int waysToGetN(int n) {
        if(n == 0 || n == 1 || n == 2) return 1;  //{} | {1} | {1, 1}
        if(n == 3) return 2;  //{1, 1, 1}, {3}

        int subProblem1 = waysToGetN(n - 1);    // 1 + waysToGet(N-1)
        int subProblem2 = waysToGetN(n - 3);    // 3 + waysToGet(N-3)
        int subProblem3 = waysToGetN(n - 4);    // 4 + waysToGet(N-4)
        return subProblem1 + subProblem2 + subProblem3;
    }
}
