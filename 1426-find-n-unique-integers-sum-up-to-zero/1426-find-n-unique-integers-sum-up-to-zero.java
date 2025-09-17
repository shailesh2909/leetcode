class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];

        int j = 0;
        for(int i = 0; i < n / 2; i++)
        {
            ans[j] = i + 1;
            j++;
            ans[j] = -(i + 1);
            j++;
        }

        return ans;
    }
}