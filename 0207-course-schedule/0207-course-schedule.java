class Solution {

    public boolean dfs(int node, boolean[] vis, boolean[] recPath, List<List<Integer>> adj)
    {
        vis[node] = true;
        recPath[node] = true;

        for(int ele : adj.get(node))
        {
            if(!vis[ele])
            {
                if(dfs(ele, vis, recPath, adj))
                {
                    return true;
                }
            }
            else if(recPath[ele])
            {
                return true;
            }
        }

        recPath[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edges: prerequisites)
        {
            adj.get(edges[1]).add(edges[0]);
        }

        boolean vis[] = new boolean[numCourses];
        boolean recPath[] = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++)
        {
            if(!vis[i])
            {
                if(dfs(i, vis, recPath, adj))
                {
                    return false;
                }
            }
        }
        return true;
    }
}