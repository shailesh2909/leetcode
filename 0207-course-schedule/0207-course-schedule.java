class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edges: prerequisites)
        {
            adj.get(edges[1]).add(edges[0]);
            indegree[edges[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int curr = q.poll();

            for(int ele : adj.get(curr))
            {
                indegree[ele]--;
                if(indegree[ele] == 0)
                {
                    q.offer(ele);
                }
            }
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] > 0)
            {
                return false;
            }
        }

        return true;
    }
}