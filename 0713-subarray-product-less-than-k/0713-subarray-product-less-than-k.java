class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        int i = 0;
        int j = 0;
        int product = 1;
        int cnt = 0;

        while (j < nums.length) 
        {

            product *= nums[j];

            while (product >= k) 
            {
                product /= nums[i];
                i++;
            }

            cnt += j - i + 1;

            j++;
        }

        return cnt;
    }
}