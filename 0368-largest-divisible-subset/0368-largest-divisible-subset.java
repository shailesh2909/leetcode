class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        
        int dp[] = new int[n];
        int hash[] = new int[n];

        Arrays.fill(dp, 1);

        int max = 1;
        int lastInd = 0;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++)
        {
            hash[i] = i;

            for(int prev = 0; prev < i; prev++)
            {
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if(dp[i] > max)
            {
                max = dp[i];
                lastInd = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastInd]);

        while(hash[lastInd] != lastInd)
        {
            lastInd = hash[lastInd];
            ans.add(nums[lastInd]);
        }

        Collections.reverse(ans);

        return ans;
    }
}