class Solution {

    int getSum(int n)
    {
        int ans = 0;

        while(n > 0)
        {
            int rem = n % 10;
            ans += rem;

            n = n / 10;
        }

        return ans;
    }

    public int minElement(int[] nums) {

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            ans = Math.min(ans, getSum(nums[i]));
        }

        return ans;
    }
}