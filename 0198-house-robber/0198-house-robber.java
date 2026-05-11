class Solution {
    public int rob(int[] nums) {
        
        int prev = 0;
        int prev2 = 0;

        for(int i = 0; i < nums.length; i++)
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

        return prev;
    }
}