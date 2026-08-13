class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        
        int after[][] = new int[2][k+1];
        int curr[][] = new int[2][k+1];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for(int cap = 0; cap <= k; cap++)
                {

                    int profit = 0;

                    if(buy == 1)
                    {
                        profit = Math.max(-prices[i] + after[0][cap], after[1][cap]);
                    }
                    else
                    {
                        if(cap > 0)
                        {
                            profit = Math.max(prices[i] + after[1][cap - 1], after[0][cap]);
                        }
                        else
                        {
                            profit = after[0][cap];
                        }
                    }

                    curr[buy][cap] = profit;
                }
            }

            after = curr;
        }

        return after[1][k];
        
    }
}