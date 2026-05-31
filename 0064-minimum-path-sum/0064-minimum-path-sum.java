class Solution {

    int solve(int row, int col, int m, int n, int[][] grid, int[][] dp)
    {
        if(row == 0 && col == 0)
        {
            return grid[row][col];
        }

        if(row < 0 || col < 0)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != 0) return dp[row][col];

        int ans = Integer.MAX_VALUE;

        int down = solve(row - 1, col, m, n, grid, dp);
        int right = solve(row, col - 1, m, n, grid, dp);

        if(down != Integer.MAX_VALUE)
        {
            ans = Math.min(ans, grid[row][col] + down);
        }

        if(right != Integer.MAX_VALUE)
        {
            ans = Math.min(ans, grid[row][col] + right);
        }

        return dp[row][col] = ans;
    }
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        return solve(m - 1, n - 1, m, n, grid, dp);
    }
}