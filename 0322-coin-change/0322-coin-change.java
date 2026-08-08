class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        
        int dp[][] = new int[n][amount + 1];

        for(int target = 0; target <= amount; target++)
        {
            if(target % coins[0] == 0)
            {
                dp[0][target] = target / coins[0];
            }
            else
            {
                dp[0][target] = (int) 1e9;
            }
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int t = 0; t <= amount; t++)
            {
                int nontake = 0 + dp[ind - 1][t];

                int take = Integer.MAX_VALUE;

                if(coins[ind] <= t)
                {
                    take = 1 + dp[ind][t - coins[ind]];
                }

                dp[ind][t] = Math.min(take, nontake);
            }

        }
        int ans = dp[n - 1][amount];
        return ans == 1e9 ? -1 : ans;
    }
}