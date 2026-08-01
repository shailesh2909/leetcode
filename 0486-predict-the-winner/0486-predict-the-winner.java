class Solution {

    public boolean find(int[] nums, int low, int high, int scoreA, int scoreB, boolean player)
    {

        if(low == high)
        {
            if(player)
            {
                scoreA += nums[low];
            }
            else
            {
                scoreB += nums[low];
            }

            return scoreA >= scoreB;
        }

        boolean takeLow;
        boolean takeHigh;

        if(player)
        {
            takeLow = find(nums, low + 1, high, scoreA + nums[low], scoreB, false);
            takeHigh = find(nums, low, high - 1, scoreA + nums[high], scoreB, false);

            return takeLow || takeHigh;
        }
        else
        {
            takeLow = find(nums, low + 1, high, scoreA, scoreB + nums[low], true);
            takeHigh = find(nums, low, high - 1, scoreA, scoreB + nums[high], true);

            return takeLow && takeHigh;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        
        return find(nums, 0, nums.length - 1, 0, 0, true);
    }
}