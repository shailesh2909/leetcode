class Solution {

    public int solve(int i, int buy, int[] prices, Integer [][]dp)
    {
        if(i == prices.length)
        {
            return 0;
        }

        if(dp[i][buy] != null)
        {
            return dp[i][buy];
        }

        int profit = 0;
        
        if(buy == 1)
        {
            profit = Math.max(-prices[i] + solve(i + 1, 0, prices, dp), solve(i + 1, 1, prices, dp));
        }
        else
        {
            profit = Math.max(prices[i] + solve(i + 1, 1, prices, dp), solve(i + 1, 0, prices, dp));
        }

        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length; 

        Integer dp[][] = new Integer[n][2];
        return solve(0, 1, prices, dp);
    }
}