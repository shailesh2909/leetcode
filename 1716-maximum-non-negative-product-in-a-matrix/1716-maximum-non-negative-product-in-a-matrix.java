class Solution {

    public int maxProductPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];

        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        //first row
        for(int i = 1; i < n; i++)
        {
            maxDp[0][i] = maxDp[0][i - 1] * grid[0][i];
            minDp[0][i] = maxDp[0][i];
        }

        //first col
        for(int i = 1; i < m; i++)
        {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = maxDp[i][0];
        }

        //compute res

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                long a = maxDp[i][j - 1] * grid[i][j];
                long b = minDp[i][j - 1] * grid[i][j];

                long c = maxDp[i - 1][j] * grid[i][j];
                long d = minDp[i - 1][j] * grid[i][j];
                
                maxDp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = maxDp[m - 1][n - 1];

        if(ans < 0)
        {
            return -1;
        }

        return (int)(ans % 1000000007);
    }
}