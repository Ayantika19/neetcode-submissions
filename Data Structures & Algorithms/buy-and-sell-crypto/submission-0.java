class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuy = prices[0];
        for(int i = 0; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }
}
