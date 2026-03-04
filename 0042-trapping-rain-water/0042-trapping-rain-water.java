class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int mxRight = 0;
        int mxLeft = 0;

        for(int i = 0; i < n; i++)
        {
            left[i] = mxLeft;
            right[n - i - 1] = mxRight;

            mxLeft = Math.max(mxLeft, height[i]);
            mxRight = Math.max(mxRight, height[n - i - 1]);
        }

        int ans = 0;
        
        for(int i = 0; i < height.length; i++)
        {
            int min = Math.min(left[i], right[i]);

            if(min - height[i] > 0)
            {
                ans += min - height[i];
            }
        }

        return ans;
    }
}