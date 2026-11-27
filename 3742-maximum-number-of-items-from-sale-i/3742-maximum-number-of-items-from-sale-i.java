class Solution {

    int[][][] dp;
    int[] free;

    int solve(int curr, int items[][], int budget, int bought) {

        if (curr == items.length)
            return 0;

        if (dp[curr][budget][bought] != -1)
            return dp[curr][budget][bought];

        int nontake = solve(curr + 1, items, budget, 0);

        int take = 0;

        if (budget >= items[curr][1]) {
            if (bought == 0) {
                take = 1 + free[curr] + solve(curr, items, budget - items[curr][1], 1);
            } else {
                take = 1 + solve(curr, items, budget - items[curr][1], 1);
            }
        }

        return dp[curr][budget][bought] = Math.max(take, nontake);
    }

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        free = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        dp = new int[n][budget + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= budget; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(0, items, budget, 0);
    }
}