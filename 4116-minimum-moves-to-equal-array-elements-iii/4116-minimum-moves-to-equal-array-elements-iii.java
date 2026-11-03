class Solution {
    public int minMoves(int[] nums) {
        
        int max = nums[0];
        int ans = 0;

        for(int e: nums)
        {
            max = Math.max(max, e);
        }

        for(int e: nums)
        {
            ans += max - e;
        }
        
        return ans;
    }
}