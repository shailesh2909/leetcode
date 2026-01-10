class Solution {
    public double myPow(double n, int m) {

        double ans = 1.0;
        long nn = m;

        if (nn < 0) {
            nn = -nn;
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * n;
                nn = nn - 1;
            } else {
                n = n * n;
                nn = nn / 2;
            }
        }

        if (m < 0) {
            ans = 1.0 / ans;
        }

        return ans;
    }
}
