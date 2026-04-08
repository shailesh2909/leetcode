class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {

        int mod = 1000000007;

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            int idx = l;

            while (idx <= r) 
            {
                nums[idx] = (int)((1L * nums[idx] * v) % mod);
                idx += k;
            }
        }

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}