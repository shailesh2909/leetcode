class Solution {
    public int minimumDifference(int[] nums, int k) {

        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < nums.length; i++)
        {
            int curr = nums[i + k - 1] - nums[i];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}
