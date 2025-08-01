class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 =  Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(count1 == 0 && ele2 != nums[i])
            {
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 && ele1 != nums[i])
            {
                count2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1)
            {
                count1++;
            }
            else if(nums[i] == ele2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(ele1 == nums[i])
            {
                count1++;
            }
            if(ele2 == nums[i])
            {
                count2++;
            }
        }

        int mini = nums.length / 3 + 1;

        if(count1 >= mini)
        {
            ans.add(ele1);
        }

        if(count2 >= mini)
        {
            ans.add(ele2);
        }

        return ans;
    }
}