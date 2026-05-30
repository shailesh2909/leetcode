class Solution {
    static class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            for (idx++; idx <= n + 1; idx += idx & -idx) {
                bit[idx] = Math.max(bit[idx], val);
            }
        }

        int query(int idx) {
            int res = 0;
            for (idx++; idx > 0; idx -= idx & -idx) {
                res = Math.max(res, bit[idx]);
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        Fenwick bit = new Fenwick(MAX);

        int prev = 0;
        for (int pos : obstacles) {
            if (pos == 0)
                continue;
            bit.update(pos, pos - prev);
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                int p = obstacles.floor(x);
                int best = Math.max(bit.query(p), x - p);

                ans.add(best >= sz);
            } else {
                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                if (left != null && right != null) {
                    bit.update(right, right - left);
                }
                obstacles.remove(x);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}