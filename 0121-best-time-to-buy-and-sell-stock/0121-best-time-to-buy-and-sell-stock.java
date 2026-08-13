class Solution {
    public int maxProfit(int[] prices) {
        
        int ans = Integer.MIN_VALUE;

        int min = prices[0];

        for(int i = 1; i < prices.length; i++)
        {
            int cost = prices[i] - min;
            ans = Math.max(ans, cost);
            min = Math.min(prices[i], min);
        }

        return ans < 0 ? 0 : ans;
    }
}