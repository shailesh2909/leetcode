class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int last = n - 1;
        int prefMax = Integer.MIN_VALUE;
        int suffMax = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {

            if(pre == 0)
            {
                pre = 1;
            }
            if(suff == 0)
            {
                suff = 1;
            }
            
            pre = pre * nums[i];
            suff = suff * nums[last];

            prefMax = Math.max(pre, prefMax);
            suffMax = Math.max(suff, suffMax);

            last--;

        }

        return Math.max(suffMax, prefMax);
    }
}