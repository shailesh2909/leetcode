class Solution {

    public void dfs(int i, boolean[] vis, List<List<Integer>> adj)
    {
        vis[i] = true;

        for(int ele : adj.get(i))
        {
            if(!vis[ele]) dfs(ele, vis, adj);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int [] ele : invocations)
        {
            adj.get(ele[0]).add(ele[1]);
        }

        boolean[] vis = new boolean[n];

        dfs(k, vis, adj);

        for(int[] ele : invocations)
        {
            int u = ele[0];
            int v = ele[1];
        
            if(!vis[u] && vis[v])
            {
                for(int i = 0; i < n; i++)
                {
                    ans.add(i);
                }

                return ans;
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                ans.add(i);
            }
        }

        return ans;
    }
}