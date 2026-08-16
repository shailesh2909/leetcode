class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int dp[] = new int[n];
        int count[] = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            dp[i] = 1;
            count[i] = 1;

            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i] && 1 + dp[j] > dp[i])
                {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                }
                else if(nums[j] < nums[i] && 1 + dp[j] == dp[i])
                {
                    count[i] += count[j];
                }
            }

            if(dp[i] > max)
            {
                max = dp[i];
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            if(dp[i] ==  max)
            {
                ans += count[i];
            }
        }

        return ans;
        
    }
}