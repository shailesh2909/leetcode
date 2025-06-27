class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;

        for(int i = 0; i<nums.length; i++)
        {
            if(count == 0)
            {
                count = 1;
                ele = nums[i];
            }
            else if(nums[i] == ele)
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        int cnt1 = 0;

        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == ele)
            {
                cnt1++;
            }
        }

        if(cnt1 > (nums.length / 2))
        {
            return ele;
        }

        return -1;
    }
}