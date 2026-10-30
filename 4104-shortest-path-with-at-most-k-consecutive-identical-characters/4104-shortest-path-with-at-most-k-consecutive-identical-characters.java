class Solution {

    class Pair {
        int node;
        int count;
        long cost;

        Pair(int node, int count, long cost) {
            this.node = node;
            this.count = count;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]> adj[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        dist[0][1] = 0;
        pq.add(new Pair(0, 1, 0));

        while(!pq.isEmpty()) {

            Pair p = pq.poll();

            int node = p.node;
            int count = p.count;
            long cost = p.cost;

            if(cost != dist[node][count]) continue;

            if(node == n - 1) return (int)cost;

            for(int[] next : adj[node]) {

                int v = next[0];
                int weight = next[1];

                int newCount;

                if(labels.charAt(node) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if(newCount > k) continue;

                long newCost = cost + weight;

                if(newCost < dist[v][newCount]) {
                    dist[v][newCount] = newCost;
                    pq.add(new Pair(v, newCount, newCost));
                }
            }
        }

        return -1;
    }
}