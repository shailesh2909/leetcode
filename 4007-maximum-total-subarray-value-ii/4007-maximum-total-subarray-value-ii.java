class Solution {

    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] stMax;
    int[][] stMin;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            long value = rangeValue(l, n - 1);
            pq.offer(new Node(value, l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                long nextVal = rangeValue(cur.l, nr);

                pq.offer(new Node(nextVal, cur.l, nr));
            }
        }

        return ans;
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            int len = 1 << j;

            for (int i = 0; i + len <= n; i++) {
                stMax[j][i] =
                        Math.max(stMax[j - 1][i],
                                 stMax[j - 1][i + (len >> 1)]);

                stMin[j][i] =
                        Math.min(stMin[j - 1][i],
                                 stMin[j - 1][i + (len >> 1)]);
            }
        }
    }

    private long rangeValue(int l, int r) {
        int len = r - l + 1;
        int p = log[len];

        int mx = Math.max(
                stMax[p][l],
                stMax[p][r - (1 << p) + 1]
        );

        int mn = Math.min(
                stMin[p][l],
                stMin[p][r - (1 << p) + 1]
        );

        return (long) mx - mn;
    }
}