class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double res = Double.NEGATIVE_INFINITY;
        double avg = 0;

        int left = 0;

        for(int right = 0; right < nums.length; right++)
        {
            avg += nums[right];
            if(right - left + 1 == k)
            {
                res = Math.max(res, avg/k);
                avg -= nums[left];
                left++;
            }
        }

        return res;
    }
}