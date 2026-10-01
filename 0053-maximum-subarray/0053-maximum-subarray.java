class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;

        int left = 0;
        int right = 0;
        int curr = 0;
        int ans = Integer.MIN_VALUE;

        while(right < n)
        {
            curr += nums[right];

                ans = Math.max(curr, ans);
            
                if(curr < 0)
                {
                    while(left <= right && curr < 0)
                    {
                        curr -= nums[left];
                        left++;
                    }
                }

                right++;
        }

        return ans;
    }
}