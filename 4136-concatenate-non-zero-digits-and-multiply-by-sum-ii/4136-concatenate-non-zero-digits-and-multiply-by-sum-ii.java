class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] pos = new int[n];
        int[] digit = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos[k] = i;
                digit[k] = d;
                k++;
            }
        }

        long[] hash = new long[k + 1];
        long[] pow10 = new long[k + 1];
        int[] prefixSum = new int[k + 1];

        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < k; i++) {
            hash[i + 1] = (hash[i] * 10 + digit[i]) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digit[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, k, l);
            int right = upperBound(pos, k, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (hash[right + 1] - hash[left] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long sum = prefixSum[right + 1] - prefixSum[left];

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}