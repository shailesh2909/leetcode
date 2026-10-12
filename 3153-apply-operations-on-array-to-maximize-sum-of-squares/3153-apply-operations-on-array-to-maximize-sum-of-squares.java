class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000000007;
        int freq[] = new int[32];

        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                if((num & (1 << i)) != 0) {
                    freq[i]++;
                }
            }
        }

        long ans = 0;

        for(int i = 0; i < k; i++) {
            long num = 0;

            for(int j = 0; j < 32; j++) {
                if(freq[j] > 0) {
                    num |= (1L << j);
                    freq[j]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }

        return (int)ans;
    }
}