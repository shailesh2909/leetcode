class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int prev = 0;
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++)
        {
            int take = nums[i];
            if(i > 1)
            {
                take += prev2;
            }

            int nonTake = prev;

            int curr = Math.max(take, nonTake);

            prev2 = prev;
            prev = curr;
        }

        int ans1 = prev;

        prev = 0;
        prev2 = 0;

        for(int i = 0; i < nums.length - 1; i++)
        {
            int take = nums[i];
            if(i > 1)
            {
                take += prev2;
            }

            int nonTake = prev;

            int curr = Math.max(take, nonTake);

            prev2 = prev;
            prev = curr;
        }

        int ans2 = prev;

        return Math.max(ans1, ans2);

    }
}