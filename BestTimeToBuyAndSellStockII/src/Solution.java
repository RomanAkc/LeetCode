public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int sum = 0;

        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] < prices[i - 1]) {
                sum += (max - min);
                min = prices[i];
                max = prices[i];
            } else {
                max = prices[i];
            }
        }

        sum += (max - min);

        return sum;
    }
}
