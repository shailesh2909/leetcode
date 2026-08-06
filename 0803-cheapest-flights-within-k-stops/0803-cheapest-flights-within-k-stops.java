class Solution {

    public int dfs(int node, int dst, int stops, List<List<int[]>> adj, int[][] dp) {

        if(node == dst)
            return 0;

        if(stops == 0)
            return Integer.MAX_VALUE;

        if(dp[node][stops] != 0)
            return dp[node][stops];

        int minCost = Integer.MAX_VALUE;

        for(int[] edge : adj.get(node)) {

            int next = edge[0];
            int price = edge[1];

            int cost = dfs(next, dst, stops - 1, adj, dp);

            if(cost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, price + cost);
            }
        }

        return dp[node][stops] = minCost;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[][] dp = new int[n][k + 2];

        int ans = dfs(src, dst, k + 1, adj, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}