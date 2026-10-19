class Solution {
    int MOD = 1000000007;
    long[] tree, sq, lazy;

    void apply(int node, int start, int end, long val) {
        long len = end - start + 1;

        sq[node] = (sq[node] + 2 * val * tree[node] + val * val * len) % MOD;
        tree[node] = (tree[node] + val * len) % MOD;
        lazy[node] += val;
    }

    void push(int node, int start, int end) {
        if(lazy[node] == 0 || start == end) return;

        int mid = (start + end) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int start, int end, int l, int r) {
        if(l > end || r < start) return;

        if(l <= start && end <= r) {
            apply(node, start, end, 1);
            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r);
        update(node * 2 + 1, mid + 1, end, l, r);

        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        tree = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for(int i = 0; i < n; i++) {
            int num = nums[i];

            update(1, 0, n - 1, last[num] + 1, i);

            ans = (ans + sq[1]) % MOD;

            last[num] = i;
        }

        return (int) ans;
    }
}