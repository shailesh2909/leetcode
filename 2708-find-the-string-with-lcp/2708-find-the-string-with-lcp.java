class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    dsu.union(i, j);
                }
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, '#');

        char ch = 'a';
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);

            if (!map.containsKey(root)) {
                if (ch > 'z') return "";
                map.put(root, ch++);
            }

            ans[i] = map.get(root);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (ans[i] == ans[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(ans);
    }
}