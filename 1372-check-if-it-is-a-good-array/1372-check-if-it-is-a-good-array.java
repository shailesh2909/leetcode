class Solution {
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];

        for (int i = 1; i < nums.length; i++) {
            g = gcd(g, nums[i]);
            if (g == 1) {
                return true;
            }
        }

        return g == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    
    }
}