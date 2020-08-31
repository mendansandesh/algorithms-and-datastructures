package problems.leetcode;

/**
 * @author sandesh.mendan on 31/08/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// TimeComplexity:  O(N)
// SpaceComplexity: O(1)
public class StockBuySell {
    public static void main(String[] args){
        int[] arr = {2,4,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minBuyPrice);
        }
        return profit;
    }
}
