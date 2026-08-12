class Solution {

    public int solve(int i, int j, String word1, String word2, int[][] dp)
    {
        if(i == 0)
        {
            return j;
        }

        if(j == 0)
        {
            return i;
        }

        if(dp[i][j] != 0)
        {
            return dp[i][j];
        }

        if(word1.charAt(i - 1) == word2.charAt(j - 1))
        {
            return dp[i][j] = solve(i - 1, j - 1, word1, word2, dp);
        }

        return dp[i][j] = 1 + Math.min(solve(i - 1, j, word1, word2, dp), Math.min(solve(i, j - 1, word1, word2, dp), solve(i - 1, j - 1, word1, word2, dp)));
    }

    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        return solve(n, m, word1, word2, dp);
    }
}