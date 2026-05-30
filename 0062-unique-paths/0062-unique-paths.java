class Solution {

    int solve(int row, int col, int m, int n, int dp[][])
    {
        if(row == m - 1 && col == n - 1)
        {
            return 1;
        }

        if(row >= m || col >= n)
        {
            return 0;
        }

        if(dp[row][col] != 0) return dp[row][col];

        int down = solve(row + 1, col, m, n, dp);
        int right = solve(row, col + 1, m, n, dp);

        return dp[row][col] = down + right;
    }

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        return solve(0, 0, m, n, dp);    
    }
}