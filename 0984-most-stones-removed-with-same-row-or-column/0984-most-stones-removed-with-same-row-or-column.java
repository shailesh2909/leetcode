class DisjointSet
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i = 0; i < n; i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node)
    {
        if(node == parent.get(node))
        {
            return node;
        }

        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v)
    {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }   
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;

        for(int i = 0; i < n; i++)
        {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxCol + maxRow + 2);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            int newRow = stones[i][0];
            int newCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(newRow, newCol);

            map.put(newRow, 1);
            map.put(newCol, 1);
        }

        int cnt = 0;

        for(Map.Entry<Integer, Integer> it : map.entrySet())
        {
            if(ds.findUpar(it.getKey()) == it.getKey())
            {
                cnt++;
            }
        }

        return n - cnt;
    }
}