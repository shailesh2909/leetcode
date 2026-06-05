class Solution {

    static class Node {
        long cnt;
        long sum;

        Node(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Node[][][][] memo;
    private boolean[][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        memo = new Node[len][11][11][2];
        vis = new boolean[len][11][11][2];

        return dfs(0, 10, 10, 0, true).sum;
    }

    private Node dfs(int pos, int prev1, int prev2, int started, boolean tight) {
        if (pos == digits.length) {
            return new Node(started == 1 ? 1 : 0, 0);
        }

        if (!tight && vis[pos][prev1][prev2][started]) {
            return memo[pos][prev1][prev2][started];
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean ntight = tight && (d == limit);

            if (started == 0 && d == 0) {
                Node nxt = dfs(pos + 1, 10, 10, 0, ntight);
                totalCnt += nxt.cnt;
                totalSum += nxt.sum;
            } else {
                int add = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                int nPrev2 = (prev1 == 10) ? 10 : prev1;
                int nPrev1 = d;

                Node nxt = dfs(pos + 1, nPrev1, nPrev2, 1, ntight);

                totalCnt += nxt.cnt;
                totalSum += nxt.sum + nxt.cnt * add;
            }
        }

        Node ans = new Node(totalCnt, totalSum);

        if (!tight) {
            vis[pos][prev1][prev2][started] = true;
            memo[pos][prev1][prev2][started] = ans;
        }

        return ans;
    }
}