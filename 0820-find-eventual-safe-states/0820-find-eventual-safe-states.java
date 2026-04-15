class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        for(int i = 0 ; i < graph.length; i++)
        {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++)
        {
            for(int it : graph[i])
            {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int it : adjRev.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}