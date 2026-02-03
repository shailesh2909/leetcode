class Solution {
    public boolean isTrionic(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int i = 0;
        int n = nums.length;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        int mid = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        if (i == mid || i == n - 1) {
            return false;
        }

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
