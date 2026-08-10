class Solution {

    public int solve(int i1, int i2, String s1, String s2, int[][] dp)
    {

        if(i1 == -1 || i2 == -1)
        {
            return 0;
        }

        if(dp[i1][i2] != -1)
        {
            return dp[i1][i2];
        }
        int match = Integer.MIN_VALUE;

        if(s1.charAt(i1) == (s2.charAt(i2)))
        {
            return dp[i1][i2] = 1 + solve(i1 - 1, i2 - 1, s1, s2, dp);
        }

        return dp[i1][i2] = Math.max(solve(i1 - 1, i2, s1, s2, dp), solve(i1, i2 - 1, s1, s2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, text1, text2, dp);
    }
}