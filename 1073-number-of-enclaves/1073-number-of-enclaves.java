class Solution {

    public void dfs(int row, int col, int[][] vis, int[][] mat, int delRow[], int delCol[])
    {
        vis[row][col] = 1;

        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && mat[nRow][nCol] == 1)
            {
                dfs(nRow, nCol, vis, mat, delRow, delCol);
            }
        }
    }

    public int numEnclaves(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        for(int i = 0; i < m; i++)
        {
            if(vis[0][i] == 0 && mat[0][i] == 1)
            {
                dfs(0, i, vis, mat, delRow, delCol);
            }

            if(vis[n - 1][i] == 0 && mat[n - 1][i] == 1)
            {
                dfs(n - 1, i, vis, mat, delRow, delCol);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(vis[i][0] == 0 && mat[i][0] == 1)
            {
                dfs(i, 0, vis, mat, delRow, delCol);
            }

            if(vis[i][m - 1] == 0 && mat[i][m - 1] == 1)
            {
                dfs(i, m - 1, vis, mat, delRow, delCol);
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == 0 && mat[i][j] == 1)
                {
                    ans++;
                }
            }
        }

        return ans;
        
    }
}