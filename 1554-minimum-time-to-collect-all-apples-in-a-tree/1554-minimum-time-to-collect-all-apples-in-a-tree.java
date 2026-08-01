class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int [] edge : edges)
        {
            map.putIfAbsent(edge[0], new LinkedList<>());
            map.putIfAbsent(edge[1], new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return find(0, map, new HashSet<>(), hasApple);
    }

    int find(int i, Map<Integer, List<Integer>> map, Set<Integer> visited, List<Boolean> hasApple)
    {
        visited.add(i);

        int minTime = 0;

        for(int child : map.getOrDefault(i, new LinkedList<>()))
        {
            if(visited.contains(child))
            {
                continue;
            }

            int childTime = find(child, map, visited, hasApple);

            boolean hasChild = hasApple.get(child) || childTime > 0;

            if(hasChild)
            {
                minTime += 2 + childTime;
            }
        }

        return minTime;
    }
}