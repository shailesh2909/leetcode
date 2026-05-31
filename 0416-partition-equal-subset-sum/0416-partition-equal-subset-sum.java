class Solution {

    boolean solve(int nums[], int k)
    {
        boolean[] prev = new boolean[k+1];

        prev[0] = true;

        if(nums[0] <= k)
            prev[nums[0]] = true;

        for(int i = 1; i < nums.length; i++)
        {
            boolean[] curr = new boolean[k+1];

            for(int target = 1; target <= k; target++)
            {
                boolean nontake = prev[target];
                boolean take = false;

                if(nums[i] <= target) take = prev[target - nums[i]];

                curr[target] = take | nontake;
            }

            prev = curr;
        }

        return prev[k];
    }

    public boolean canPartition(int[] nums) {
        
        int sum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        return solve(nums, sum / 2);
    }
}