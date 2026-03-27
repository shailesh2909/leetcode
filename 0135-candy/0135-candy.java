class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // Left â Right
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        // Right â Left
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }

        int sum = 0;
        for(int x : ans) sum += x;

        return sum;
    }
}