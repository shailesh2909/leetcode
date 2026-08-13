class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        
        int dp[][][] = new int[n+1][2][3];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for(int cap = 0; cap <= 2; cap++)
                {

                    int profit = 0;

                    if(buy == 1)
                    {
                        profit = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                    }
                    else
                    {
                        if(cap > 0)
                        {
                            profit = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                        }
                        else
                        {
                            profit = dp[i + 1][0][cap];
                        }
                    }

                    dp[i][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}