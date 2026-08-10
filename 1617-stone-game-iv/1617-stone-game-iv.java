class Solution {

    public boolean solve(int n, Boolean[] dp)
    {
        if(n == 0)
        {
            return false;
        }
        
        if(dp[n] != null)
        {
            return dp[n];
        }

        for(int i = 1; i * i <= n; i++)
        {
            int sq = i * i;
            if(!solve(n - sq, dp))
            {
                return dp[n] = true;
            }
            
        }
        return dp[n] = false;

    }

    public boolean winnerSquareGame(int n) {
        
        Boolean dp[] = new Boolean[n + 1];
        return solve(n, dp);
    }
}