class Solution {

    public int solve(int ind, int target, int[] coins, int[][] dp)
    {

        if(ind == 0)
        {
            if(target % coins[ind] == 0)
            {
                return target / coins[ind];
            }
            else
            {
                return (int)1e9;
            }
        }

        if(dp[ind][target] != 0)
        {
            return dp[ind][target];
        }

        int nontake = 0 + solve(ind - 1, target, coins, dp);

        int take = Integer.MAX_VALUE;

        if(coins[ind] <= target)
        {
            take = 1 + solve(ind, target - coins[ind], coins, dp);
        }

        return dp[ind][target] = Math.min(take, nontake);
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        
        int dp[][] = new int[n][amount + 1];

        int ans = solve(n - 1, amount, coins, dp);
        return ans == 1e9 ? -1 : ans;
    }
}