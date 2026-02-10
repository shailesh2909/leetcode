class Solution {

    public boolean find(int[] nums, int low, int high, int scorea, int scoreb, boolean player) {

        if (low == high) {
            if (player) scorea += nums[low];
            else scoreb += nums[low];
            return scorea >= scoreb;
        }

        boolean takeLeft, takeRight;

        if (player) {
            takeLeft  = find(nums, low + 1, high, scorea + nums[low], scoreb, false);
            takeRight = find(nums, low, high - 1, scorea + nums[high], scoreb, false);
            return takeLeft || takeRight;
        } else {
            takeLeft  = find(nums, low + 1, high, scorea, scoreb + nums[low], true);
            takeRight = find(nums, low, high - 1, scorea, scoreb + nums[high], true);
            return takeLeft && takeRight;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        return find(nums, 0, nums.length - 1, 0, 0, true);
    }
}
