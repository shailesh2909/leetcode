class Solution {
    int LOG = 17;
    int[][] up;
    int[] depth, tin, tout, rootMask;
    int timer;
    char[] chars;
    List<Integer>[] adj;
    Fenwick bit;

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            while(i < tree.length) {
                tree[i] ^= val;
                i += i & -i;
            }
        }

        void rangeUpdate(int l, int r, int val) {
            update(l + 1, val);
            update(r + 2, val);
        }

        int query(int i) {
            int ans = 0;

            while(i > 0) {
                ans ^= tree[i];
                i -= i & -i;
            }

            return ans;
        }
    }

    void dfs(int root) {
        int n = adj.length;

        int[] stackNode = new int[2 * n + 5];
        int[] stackParent = new int[2 * n + 5];
        boolean[] exit = new boolean[2 * n + 5];

        int top = 0;

        stackNode[top] = root;
        stackParent[top] = -1;
        exit[top++] = false;

        while(top > 0) {
            top--;

            int node = stackNode[top];
            int parent = stackParent[top];

            if(exit[top]) {
                tout[node] = timer - 1;
                continue;
            }

            up[0][node] = parent == -1 ? node : parent;
            depth[node] = parent == -1 ? 0 : depth[parent] + 1;

            rootMask[node] = (parent == -1 ? 0 : rootMask[parent])
                           ^ (1 << (chars[node] - 'a'));

            tin[node] = timer++;

            stackNode[top] = node;
            stackParent[top] = parent;
            exit[top++] = true;

            for(int next : adj[node]) {
                if(next == parent) continue;

                stackNode[top] = next;
                stackParent[top] = node;
                exit[top++] = false;
            }
        }
    }

    int lca(int u, int v) {
        if(depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for(int i = 0; i < LOG; i++) {
            if((diff & (1 << i)) != 0) {
                u = up[i][u];
            }
        }

        if(u == v) return u;

        for(int i = LOG - 1; i >= 0; i--) {
            if(up[i][u] != up[i][v]) {
                u = up[i][u];
                v = up[i][v];
            }
        }

        return up[0][u];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        chars = s.toCharArray();
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        rootMask = new int[n];
        up = new int[LOG][n];
        timer = 0;

        dfs(0);

        for(int i = 1; i < LOG; i++) {
            for(int j = 0; j < n; j++) {
                up[i][j] = up[i - 1][up[i - 1][j]];
            }
        }

        bit = new Fenwick(n);

        List<Boolean> ans = new ArrayList<>();

        for(String q : queries) {
            String[] parts = q.split(" ");

            if(parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[node] - 'a');
                int newMask = 1 << (c - 'a');
                int change = oldMask ^ newMask;

                if(change != 0) {
                    bit.rangeUpdate(tin[node], tout[node], change);
                    chars[node] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int parent = lca(u, v);

                int maskU = rootMask[u] ^ bit.query(tin[u] + 1);
                int maskV = rootMask[v] ^ bit.query(tin[v] + 1);
                int maskParent = 1 << (chars[parent] - 'a');

                int mask = maskU ^ maskV ^ maskParent;

                ans.add(Integer.bitCount(mask) <= 1);
            }
        }

        return ans;
    }
}