class Solution {
    public int jump(int[] nums) {
        
        int jumps = 0, curr = 0, far = 0;

        for(int i = 0; i < nums.length; i++)
        {
            far = Math.max(far, i + nums[i]);

            if(i == curr)
            {
                jumps++;
                curr = far;
            }

            if(curr >= nums.length - 1)
            {
                break;
            }
        }

        return jumps;
    }
}