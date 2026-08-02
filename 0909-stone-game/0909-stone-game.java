class Solution {

    public int find(int i, int j, int dp[][], int[] piles)
    {
        if(i == j)
        {
            return piles[i];
        }

        if(dp[i][j] != 0)
        {
            return dp[i][j];
        }

        int take = piles[i] + find(i + 1, j, dp, piles);
        int nonTake = piles[i] + find(i, j - 1, dp, piles);

        return dp[i][j] = Math.max(take, nonTake);
    }
    public boolean stoneGame(int[] piles) {
        
        int dp[][] = new int[piles.length][piles.length];
        return find(0, 0, dp, piles) > 0 ? true : false;
    }
}