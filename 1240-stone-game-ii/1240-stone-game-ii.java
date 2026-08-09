class Solution {

    public int solve(int ind, int m, int[] piles, int[][] dp)
    {
        int n = piles.length;

        if(ind >= n)
        {
            return 0;
        }

        if(dp[ind][m] != -1)
        {
            return dp[ind][m];
        }

        int best = Integer.MIN_VALUE;
        int score = 0;

        for(int x = 1; x <= 2 * m && ind + x <= n; x++)
        {
            score += piles[ind + x - 1];

            int next = solve(
                ind + x,
                Math.max(m, x),
                piles,
                dp
            );

            best = Math.max(best, score - next);
        }

        return dp[ind][m] = best;
    }

    public int stoneGameII(int[] piles)
    {
        int n = piles.length;

        int[][] dp = new int[n][2 * n + 1];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        int total = 0;

        for(int num : piles)
        {
            total += num;
        }

        int diff = solve(0, 1, piles, dp);

        return (total + diff) / 2;
    }
}