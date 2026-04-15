class Solution {

    public boolean check(int start, int[][] graph, int[] color)
    {
        Queue<Integer> q = new LinkedList<>();
        color[start] = 0;
        q.add(start);

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();

            for(int it : graph[node])
            {
                if(color[it] == -1)
                {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it] == color[node])
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        
        int v = graph.length;
        int[] color = new int[v];

        for(int i = 0; i < v; i++)
        {
            color[i] = -1;
        }

        for(int i = 0; i < v; i++)
        {
            if(color[i] == -1)
            {
                if(!check(i, graph, color))
                {
                    return false;
                }
            }
        }

        return true;
    }
}