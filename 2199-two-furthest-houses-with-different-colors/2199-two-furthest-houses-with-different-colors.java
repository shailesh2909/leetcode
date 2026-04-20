class Solution {
    public int maxDistance(int[] colors) {
        
        int ans = Integer.MIN_VALUE;
        int n = colors.length;

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(colors[i] != colors[j])
                {
                    ans = Math.max(ans, Math.abs(i - j));
                }
            }
        }

        return ans;
    }
}