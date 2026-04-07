class Solution {

    public void dfs(int node, int[][] adj, boolean vis[])
    {
        vis[node] = true;

        for(int i = 0; i < adj.length; i++)
        {
            if(adj[node][i] == 1 && vis[i] == false)
            {
                dfs(i, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int ans = 0;
        boolean vis[] = new boolean[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!vis[i])
            {
                dfs(i, isConnected, vis);
                ans++;
            }
        }

        return ans;
    }
}