class Solution {

    int solve(int row, int col, int m, int n, int[][] arr, int[][] dp)
    {
        if(row < m && col < n && arr[row][col] == 1) return 0;

        if(row == m - 1 && col == n - 1)
        {
            return 1;
        }

        if(row >= m || col >= n)
        {
            return 0;
        }

        if(dp[row][col] != 0) return dp[row][col];

        int down = solve(row + 1, col, m, n, arr, dp);
        int right = solve(row, col + 1, m, n, arr, dp);

        return dp[row][col] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        return solve(0, 0, m, n, obstacleGrid, dp);
    }
}