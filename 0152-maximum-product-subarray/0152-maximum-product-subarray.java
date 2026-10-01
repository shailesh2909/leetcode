class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        
        int pref = 1;
        int suff = 1;
        int last = n - 1;
        int prefMax = Integer.MIN_VALUE;
        int suffMax = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
        {
            if(pref == 0)
            {
                pref = 1;
            }

            if(suff == 0)
            {
                suff = 1;
            }

            pref = pref * nums[i];
            suff = suff * nums[last];

            prefMax = Math.max(pref, prefMax);
            suffMax = Math.max(suff, suffMax);
            last--;
        }

        return Math.max(prefMax, suffMax);
    }
}