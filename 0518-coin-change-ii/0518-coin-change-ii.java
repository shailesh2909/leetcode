class Solution {

    public int solve(int ind, int sum, int[] nums, int[][] dp)
    {
        if(ind == 0)
        {
            if(sum % nums[ind] == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if(dp[ind][sum] != -1)
        {
            return dp[ind][sum];
        }

        int nontake = solve(ind - 1, sum, nums, dp);
        int take = 0;

        if(nums[ind] <= sum)
        {
            take = solve(ind, sum - nums[ind], nums, dp);
        }

        return dp[ind][sum] = take + nontake;
    }

    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, amount, coins, dp);
    }
}