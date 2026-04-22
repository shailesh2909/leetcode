class Tuple
{
    int distance;
    int row;
    int col;

    Tuple(int d, int r, int c)
    {
        distance = d;
        row = r;
        col = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty())
        {
            Tuple it = pq.peek();
            pq.remove();

            int dis = it.distance;
            int row = it.row;
            int col = it.col;

            if(row == n - 1 && col == m - 1)
            {
                return dis;
            }

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m)
                {
                    int eff = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), dis);

                    if(eff < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = eff;
                        pq.add(new Tuple(eff, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}