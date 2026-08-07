class Pair
{
    int node;
    int cost;

    public Pair(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {

    int cost = 0;

    public void dfs(int node, int parent, List<List<Pair>> adj)
    {
        for(Pair p : adj.get(node))
        {
            if(p.node != parent)
            {
                cost += p.cost;
                dfs(p.node, node, adj);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edges : connections)
        {
            int u = edges[0];
            int v = edges[1];

            adj.get(u).add(new Pair(v, 1));
            adj.get(v).add(new Pair(u, 0));
        }

        dfs(0, -1, adj);

        return cost;
    }
}