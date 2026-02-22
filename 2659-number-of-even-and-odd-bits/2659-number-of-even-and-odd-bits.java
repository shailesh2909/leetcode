class Solution {
    public int[] evenOddBit(int n) {
    
        int[] res = new int[2];

        int pos = 0;

        while(n > 0)
        {
            if((n & 1) == 1)
            {
                if((pos % 2) == 0)
                {
                    res[0]++;
                }
                else
                {
                    res[1]++;
                }
            }

            n = n>>1;
            pos++;
        }
        return res;
    }
}