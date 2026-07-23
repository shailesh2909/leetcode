class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == ele1) 
            {
                count1++;
            }
            else if(nums[i] == ele2)
            {
                count2++;
            }
            else if(count1 == 0)
            {
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0)
            {
                count2 = 1;
                ele2 = nums[i];
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums)
        {
            if(num == ele1)
            {
                count1++;
            }
            else if(num == ele2)
            {
                count2++;
            }
        }

        if(count1 > n / 3)
        {
            ans.add(ele1);
        }

        if(count2 > n / 3)
        {
            ans.add(ele2);
        }

        return ans;
    }
}