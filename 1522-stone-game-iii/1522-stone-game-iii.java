class Solution {

    public int solve(int curr, int n, int[] stoneValue, int[] dp)
    {
        if(curr >= n)
        {
            return 0;
        }

        if(dp[curr] != Integer.MIN_VALUE)
        {
            return dp[curr];
        }

        int score = 0;
        int ans = Integer.MIN_VALUE;
        int it = Math.min(curr + 3, n);

        for(int i = curr; i < it; i++)
        {
            score += stoneValue[i];
            
            ans = Math.max(ans, score - solve(i + 1, n, stoneValue, dp));
        }

        return dp[curr] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {
        
        int dp[] = new int[stoneValue.length];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int dif = solve(0, stoneValue.length, stoneValue, dp);

        if(dif > 0)
        {
            return "Alice";
        }
        else if(dif < 0)
        {
            return "Bob";
        }
        
        return "Tie";
    }
}