class Solution {
    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 2;
        Fenwick bit = new Fenwick(2 * n + 5);

        int prefix = 0;
        long ans = 0;

        bit.add(prefix + offset, 1);

        for (int x : nums) {
            prefix += (x == target) ? 1 : -1;
            ans += bit.query(prefix - 1 + offset);
            bit.add(prefix + offset, 1);
        }

        return ans;
    }
}