class Pair
{
    int first;
    int second;

    Pair(int f, int s)
    {
        first = f;
        second = s;
    }
}

class Solution {

    public void bfs(int r, int c, int[][] vis, char[][] grid, int[] dRow, int[] dCol)
    {
        vis[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int i = 0; i < 4; i++)
            {
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1')
                    {
                        vis[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
        
            }
        }
    }

    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int[][] vis = new int[n][m];

        int cnt = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == '1')
                {
                    cnt++;
                    bfs(i, j, vis, grid, dRow, dCol);
                }
            }
        }

        return cnt;
    }
}