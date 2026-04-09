import java.util.*;

class Solution {
    int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n) + 1;

        List<int[]>[] small = new ArrayList[B];
        for (int i = 1; i < B; i++) {
            small[i] = new ArrayList<>();
        }

        for (int[] q : queries) 
        {
            int k = q[2];
            if (k < B) 
            {
                small[k].add(q);
            } 
            else 
            {
                int l = q[0], r = q[1], v = q[3];
    
                for (int i = l; i <= r; i += k) 
                {
                    nums[i] = (int) ((1L * nums[i] * v) % mod);
                }
            }
        }

        long[] mult_diff = new long[n + B];
        int[] zero_diff = new int[n + B];

        for (int k = 1; k < B; k++) 
        {
            if (small[k].isEmpty()) continue;

            Arrays.fill(mult_diff, 0, n + k, 1L);
            Arrays.fill(zero_diff, 0, n + k, 0);

            for (int[] q : small[k]) 
            {
                int l = q[0], r = q[1], v = q[3];
                
                int last = l + ((r - l) / k) * k;

                if (v % mod == 0) 
                {
                    zero_diff[l]++;
                    zero_diff[last + k]--;
                } 
                else 
                {
                    mult_diff[l] = (mult_diff[l] * v) % mod;
                    mult_diff[last + k] = (mult_diff[last + k] * modInverse(v)) % mod;
                }
            }

            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    mult_diff[i] = (mult_diff[i] * mult_diff[i - k]) % mod;
                    zero_diff[i] += zero_diff[i - k];
                }
            
                long actual_mult = zero_diff[i] > 0 ? 0 : mult_diff[i];
                nums[i] = (int) ((1L * nums[i] * actual_mult) % mod);
            }
        }

        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }

        return ans;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long n) 
    {
        return power(n, mod - 2);
    }
}