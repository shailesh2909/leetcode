class Pair
{
    int dist;
    int row; 
    int col;

    public Pair(int dist, int row, int col)
    {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;
        
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
        
        int vis[][] = new int[n][n];

        pq.add(new Pair(grid[0][0], 0, 0));
        
        int ans = 0;
        while(!pq.isEmpty())
        {
            Pair it = pq.peek();
            int dis = it.dist;
            int row = it.row;
            int col = it.col;

            pq.remove();

            if(row == n - 1 && col == n - 1) return dis;
            vis[row][col] = 1;

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0)
                {
                    int newdist = Math.max(dis, grid[nrow][ncol]);
                    pq.add(new Pair(newdist, nrow, ncol));
                }
            }
        }

        return -1;
    }
}