class Solution {
    public int hammingWeight(int n) {
        
        int res = 0;

        while(n > 1)
        {
            res += (n & 1);
            n = n >> 1;
        }

        if(n == 1)
        {
            res++;
        }
        return res;
    }
}