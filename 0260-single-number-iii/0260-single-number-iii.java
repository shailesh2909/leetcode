class Solution {
    public int[] singleNumber(int[] nums) {
        
        int res[] = new int[2];

        int xor = 0;
        for(int i = 0; i < nums.length; i++)
        {
            xor = xor ^ nums[i];
        }

        int rm = (xor & xor - 1) & xor;

        int b1 = 0;
        int b2 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if((nums[i] & rm) == 0)
            {
                b1 = b1 ^ nums[i];
            }
            else
            {
                b2 = b2 ^ nums[i];
            }
        }

        res[0] = b1;
        res[1] = b2;
        return res;
    }
}