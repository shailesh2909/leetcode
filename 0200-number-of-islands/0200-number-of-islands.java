class Pair
{
    int first;
    int second;

    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public void bfs(int row, int col, int m, int n, boolean[][] vis, char[][] grid)
    {
        vis[row][col] = true;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(row, col));

        while(!q.isEmpty())
        {
            Pair curr = q.poll();

            int nrow = curr.first;
            int ncol = curr.second;

            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    if(Math.abs(i) + Math.abs(j) != 1)
                        continue;

                    int nr = nrow + i;
                    int nc = ncol + j;

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false && grid[nr][nc] == '1')
                    {
                        vis[nr][nc] = true;
                        q.offer(new Pair(nr, nc));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean vis[][] = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(vis[i][j] == false && grid[i][j] == '1')
                {
                    count++;
                    bfs(i, j, m, n, vis, grid);
                }
            }
        }

        return count;
    }
}