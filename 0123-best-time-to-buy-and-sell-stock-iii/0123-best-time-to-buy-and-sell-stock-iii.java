class Solution {

    public int solve(int i, int buy, int[] prices, int cap, Integer [][][]dp)
    {
        if(i == prices.length || cap == 0)
        {
            return 0;
        }

        if(dp[i][buy][cap] != null)
        {
            return dp[i][buy][cap];
        }

        int profit = 0;
        
        if(buy == 1)
        {
            profit = Math.max(-prices[i] + solve(i + 1, 0, prices, cap, dp), solve(i + 1, 1, prices, cap, dp));
        }
        else
        {
            profit = Math.max(prices[i] + solve(i + 1, 1, prices,cap - 1, dp), solve(i + 1, 0, prices, cap, dp));
        }

        return dp[i][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        
        Integer dp[][][] = new Integer[prices.length][2][3];

        return solve(0, 1, prices, 2, dp);
    }
}