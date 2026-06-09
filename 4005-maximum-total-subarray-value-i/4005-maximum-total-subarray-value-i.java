class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mx = Long.MIN_VALUE;
        long mn = Long.MAX_VALUE;

        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }

        return (mx - mn) * k;
    }
}