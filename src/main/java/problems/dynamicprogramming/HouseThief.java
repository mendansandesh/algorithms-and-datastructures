package problems.dynamicprogramming;

/**
 * @author sandesh.mendan on 20/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
// Level: Easy
// TimeComplexity: O(N) - bottomUp
// SpaceComplexity: O(N) - bottomUp
public class HouseThief {
    public static void main(String[] args) {
        int[] houseNetWorth = new int[] {6, 7, 1, 3, 8, 2, 4};
        //System.out.println(findMaxDp_TopDown(houseNetWorth));
        System.out.println(findMaxDp_BottomUp(houseNetWorth));
    }

    public static int findMaxDp_TopDown(int[] houseNetWorth){
        int[] dp = new int[houseNetWorth.length + 1];
        return findMaxDp_TopDown(houseNetWorth, 0, dp);
    }

    private static int findMaxDp_TopDown(int[] houseNetWorth, int currIndex, int[] dp) {
        if(currIndex > houseNetWorth.length-1)
            return 0;
        if(dp[currIndex] == 0){
            int withCurrHouse = houseNetWorth[currIndex] + findMaxDp_TopDown(houseNetWorth, currIndex + 2, dp);
            int withoutCurrHouse =  findMaxDp_TopDown(houseNetWorth, currIndex + 1, dp);
            dp[currIndex] = Math.max(withCurrHouse, withoutCurrHouse);
        }
        return dp[currIndex];
    }

    private static int findMaxDp_BottomUp(int[] houseNetWorth) {
        int[] dp = new int[houseNetWorth.length + 2];
        for(int i = houseNetWorth.length-1; i >= 0; i--)
            dp[i] = Math.max(houseNetWorth[i] + dp[i+2], dp[i+1]);
        return dp[0];
    }
}
