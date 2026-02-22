class Solution {
    public int binaryGap(int n) {
        String bits = Integer.toBinaryString(n);

        int last = -1;
        int res = 0;

        for(int i = 0; i < bits.length(); i++)
        {
            if(bits.charAt(i) == '1')
            {
                if(last != -1)
                {
                    res = Math.max(res, i - last);
                }

                last = i;
            }
            
        }
        return res;
    }
}