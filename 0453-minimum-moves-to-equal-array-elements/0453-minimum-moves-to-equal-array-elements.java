class Solution {
    public int minMoves(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            min = Math.min(min, nums[i]);

            sum += nums[i];
        }

        long req = (long) min * nums.length;

        return (int)(sum - req);

    }
}