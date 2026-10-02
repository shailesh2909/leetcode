class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int ele = nums[0];

        for(int e : nums)
        {
            if(e == ele) count++;
            else if(count == 0) ele = e;
            else count--;
        }

        return ele;
    }
}