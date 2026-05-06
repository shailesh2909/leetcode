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

    public int findUPar(int node)
    {
        if(node == parent.get(node))
        {
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

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

    public boolean isValid(int row, int col, int n)
    {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0) continue;
                for(int ind = 0; ind < 4; ind++)
                {
                    int newr = i + dr[ind];
                    int newc = j + dc[ind];

                    if(isValid(newr, newc, n) && grid[newr][newc] == 1)
                    {
                        int node = i * n + j;
                        int adj = newr * n + newc;
                        ds.unionBySize(node, adj);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) continue;
                HashSet<Integer> temp = new HashSet<>();
                for(int ind = 0; ind < 4; ind++)
                {
                    int newr = i + dr[ind];
                    int newc = j + dc[ind];
                    
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1)
                    {
                        int adj = newr * n + newc;
                        temp.add(ds.findUPar(adj));
                    }
                }

                int size = 0;
                for(Integer ele : temp)
                {
                    size += ds.size.get(ele);
                }

                ans = Math.max(ans, size + 1);
            }
        }

        for(int i = 0; i < n* n; i++)
        {
            ans = Math.max(ans, ds.size.get(ds.findUPar(i)));
        }

        return ans;

    }
}