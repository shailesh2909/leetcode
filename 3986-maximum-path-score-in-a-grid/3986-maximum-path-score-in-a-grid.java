class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // dp[i][j][c] = max score at (i,j) with cost c
        int[][][] dp = new int[m][n][k + 1];

        // initialize with -1 (invalid)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        // starting point
        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = grid[i][j];
                int score = val;
                int cost = (val == 0) ? 0 : 1;

                for (int c = 0; c <= k; c++) {

                    // skip start cell (already initialized)
                    if (i == 0 && j == 0) continue;

                    int prevCost = c - cost;
                    if (prevCost < 0) continue;

                    int best = -1;

                    // from top
                    if (i > 0 && dp[i - 1][j][prevCost] != -1) {
                        best = Math.max(best, dp[i - 1][j][prevCost] + score);
                    }

                    // from left
                    if (j > 0 && dp[i][j - 1][prevCost] != -1) {
                        best = Math.max(best, dp[i][j - 1][prevCost] + score);
                    }

                    dp[i][j][c] = best;
                }
            }
        }

        // find max score at destination within cost k
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans;
    }
}