package interview.salesforce;

import java.util.Arrays;

/*
    Problem: Given stocks array with unique elements and budget; task is to utilize the full budget along
    with that we should ensure the purchased stocks are diversified (purchase different stocks as possible)
    return 0 if budget matches sum(array stocks);
    return reminder if sum(array stocks) exceeds budget
    if budget left over, utilize fullest i.e, iterate the process
    Time complexity: (O(NlogN) + O(N) ) x recursion O(Budget / Sum(stocks))
* */
public class DiversifyStocks {
    public static void main(String[] args) {
        int[] stocks = {1, 14, 12, 23, 4, 9};
        int budget = 1000;
        System.out.println(diversifyStocks(stocks, budget));
    }

    private static int diversifyStocks(int[] stocks, int budget) {
        Arrays.sort(stocks);
        int limit = 0;
        for(int i = 0; i < stocks.length; i++){
            limit += stocks[i];
            if(limit > budget)
                return limit - budget;
        }
        if(limit == budget)
            return 0;
        return diversifyStocks(stocks, budget - limit);
    }
}
