class Solution {
    
    public int solve(int ind, int sum, int[] nums, int[][] dp)
    {
        if(ind == 0)
        {
            if(sum == 0 && nums[0] == 0)
            {
                return 2;
            }

            if(sum == 0 || nums[0] == sum)
            {
                return 1;
            }

            return 0;
        }

        if(dp[ind][sum] != 0)
        {
            return dp[ind][sum];
        }

        int nontake = solve(ind - 1, sum, nums, dp);
        int take = 0;

        if(nums[ind] <= sum)
        {
            take = solve(ind - 1, sum - nums[ind], nums, dp);
        }

        return dp[ind][sum] = take + nontake;
    }

    public int findWays(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        return solve(n - 1, target, nums, dp);
    }

    public int partition(int n, int d, int[] arr)
    {
        int total = 0;
        for(int e : arr)
        {
            total += e;
        }

        if(total - d < 0 || (total - d) % 2 == 1) return 0;

        return findWays(arr, (total - d) / 2);
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        return partition(nums.length, target, nums);
    }
}