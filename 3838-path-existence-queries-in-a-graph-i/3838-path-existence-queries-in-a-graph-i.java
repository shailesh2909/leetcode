class DisjointSet
{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

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
        if(node == parent.get(node)) return node;

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
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else
        {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        boolean[] ans = new boolean[queries.length];
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n - 1; i++)
        {
            if(nums[i + 1] - nums[i] <= maxDiff)
            {
                ds.unionBySize(i, i+1);
            }
        }

        for(int i = 0; i < queries.length; i++)
        {
            int ulp_u = ds.findUpar(queries[i][0]);
            int ulp_v = ds.findUpar(queries[i][1]);

            if(ulp_u == ulp_v)
            {
                ans[i] = true;
            }
            else
            {
                ans[i] = false;
            }  
        }

        return ans;
    }
}













