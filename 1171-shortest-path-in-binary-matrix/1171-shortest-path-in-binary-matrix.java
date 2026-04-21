class Tuple
{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;
        
        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        if(n == 1) return 1;

        int dist[][] = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 1;
        q.add(new Tuple(1, 0, 0));

        int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(!q.isEmpty())
        {
            Tuple it = q.peek();
            q.remove();

            int dis = it.first;
            int r = it.second;
            int c = it.third;

            for(int i = 0; i < 8; i++)
            {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc])
                {
                    dist[newr][newc] = 1 + dis;

                    if(newr == n - 1 && newc == m - 1)
                    {
                        return dis + 1;
                    }

                    q.add(new Tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1;
    }
}