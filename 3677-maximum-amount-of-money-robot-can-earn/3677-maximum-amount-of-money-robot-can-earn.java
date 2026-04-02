class Solution {

    Integer[][][] dp;

    public int solve(int[][] coins, int x, int y, int k)
    {
        int n = coins.length;
        int m = coins[0].length;
        
        if(x == m - 1 && y == n - 1)
        {
            if(coins[y][x] < 0 && k > 0) return 0;
            return coins[y][x];
        }

        if(dp[y][x][k] != null) return dp[y][x][k];

        int right, down;

        if(coins[y][x] >= 0 || k == 0)
        {
            right = (x + 1 < m) ? solve(coins, x + 1, y, k) : Integer.MIN_VALUE;
            down  = (y + 1 < n) ? solve(coins, x, y + 1, k) : Integer.MIN_VALUE;

            int curr = coins[y][x];
            return dp[y][x][k] = curr + Math.max(right, down);
        }

        int skipRight = (x + 1 < m) ? solve(coins, x + 1, y, k - 1) : Integer.MIN_VALUE;
        int skipDown  = (y + 1 < n) ? solve(coins, x, y + 1, k - 1) : Integer.MIN_VALUE;
        int skip = Math.max(skipRight, skipDown);

        int takeRight = (x + 1 < m) ? solve(coins, x + 1, y, k) : Integer.MIN_VALUE;
        int takeDown  = (y + 1 < n) ? solve(coins, x, y + 1, k) : Integer.MIN_VALUE;
        int take = coins[y][x] + Math.max(takeRight, takeDown);

        return dp[y][x][k] = Math.max(skip, take);
    }

    public int maximumAmount(int[][] coins) {

        int n = coins.length;
        int m = coins[0].length;

        dp = new Integer[n][m][3];

        return solve(coins, 0, 0, 2);
    }
}