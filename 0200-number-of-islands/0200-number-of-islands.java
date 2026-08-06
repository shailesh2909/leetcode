class Pair
{
    int first;
    int second;

    public Pair(int f, int s)
    {
        first = f;
        second = s;
    }
}

class Solution {

    public void bfs(int row, int col, int m, int n, boolean[][] vis, char[][] grid)
    {
        vis[row][col] = true;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));

        int[] rdir = {-1, 1, 0, 0};
        int[] cdir = {0, 0, -1, 1};

        while(!q.isEmpty())
        {
            Pair temp = q.poll();

            int nrow = temp.first;
            int ncol = temp.second;

            for(int i = 0; i < 4; i++)
            {
                int nr = nrow + rdir[i];
                int nc = ncol + cdir[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false && grid[nr][nc] == '1')
                {
                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!vis[i][j] && grid[i][j] == '1')
                {
                    count++;
                    bfs(i, j, m, n, vis, grid);
                }
            }
        }

        return count;
    }
}