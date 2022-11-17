public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];

        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] < max - fee) {
                int profit = max - min - fee;
                maxProfit += Math.max(0, profit);
                min = prices[i];
                max = prices[i];
            } else if(prices[i] > max) {
                max = prices[i];
            } else if(prices[i] < min) {
                min = prices[i];
            }
        }

        int profit = max - min - fee;
        maxProfit += Math.max(0, profit);

        return maxProfit;
    }
}
