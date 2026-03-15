class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
            {
                nums[i] = 0;
            }
            else
            {
                nums[i] = 1;
            }
        }

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int nums[], int goal)
    {
        if(goal < 0)
        {
            return 0;
        }
        
        int cnt = 0;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++)
        {
            sum += nums[right];

            while(sum > goal)
            {
                sum -= nums[left];
                left++;
            }

            cnt += right - left + 1;
        }

        return cnt;
    }
}