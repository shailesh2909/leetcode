class Solution {

    // public int solve(int n, int[] dp)
    // {
    //     if(n <= 1)
    //     {
    //         return n;
    //     }

    //     if(dp[n] != -1)
    //     {
    //         return dp[n];
    //     }

    //     return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    // }

    // public int fib(int n) {
        
    //     int dp[] = new int[n + 1];
    //     Arrays.fill(dp, -1);

    //     return solve(n, dp);
    // }


    public int fib(int n) {
        
       if(n == 0) return 0;
       if(n == 1) return 1;
       
       int prev = 1;
       int prev2 = 0;

       for(int i = 2; i < n + 1; i++)
       {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
       }

       return prev;
    }
}