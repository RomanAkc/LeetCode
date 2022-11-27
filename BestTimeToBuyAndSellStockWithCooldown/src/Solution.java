public class Solution {
    int[] prices;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; ++i) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return getMaxProfit(0, true);
    }

    private int getMaxProfit(int j, boolean canBuy) {
        if(j >= prices.length)
            return 0;

        if(dp[j][canBuy ? 1 : 0] != -1)
            return dp[j][canBuy ? 1 : 0];

        if(canBuy) {
            dp[j][1] = Math.max(getMaxProfit(j + 1, false) - prices[j], getMaxProfit(j + 1, true));
        } else {
            dp[j][0] = Math.max(getMaxProfit(j + 2, true) + prices[j], getMaxProfit(j + 1, false));
        }

        return dp[j][canBuy ? 1 : 0];
    }
}
