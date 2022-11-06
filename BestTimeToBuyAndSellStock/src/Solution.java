import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - min;
            if(profit > 0) {
                if(profit > maxProfit)
                    maxProfit = profit;
            } else if(prices[i] < min) {
                    min = prices[i];
            }
        }

        return maxProfit;
    }

    public int maxProfit_slow(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length - 1; ++i) {
            for(int j = i + 1; j < prices.length; ++j) {
                int profit = prices[j] - prices[i];
                if(profit > 0) {
                    if(profit > maxProfit)
                        maxProfit = profit;
                }
            }
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }


}
