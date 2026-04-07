class Solution {

    public int[] dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[])
    {
        vis[node] = true;
        
        int nodes = 1;
        int edges = adj.get(node).size();

        for(int ele : adj.get(node))
        {
            if(!vis[ele])
            {
                int[] res = dfs(ele, adj, vis);
                nodes += res[0];
                edges += res[1];
            }
        }

        return new int[]{nodes, edges};
    }

    public int countCompleteComponents(int n, int[][] edges) {
        
        int ans = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] ele : edges)
        {
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
        }

        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                int res[] = dfs(i, adj, visited);
                int nodes = res[0];
                int edgeCount = res[1] / 2;

                if(edgeCount == nodes * (nodes - 1) / 2)
                {
                    ans++;
                }
            }
        }

        return ans;
    }
}