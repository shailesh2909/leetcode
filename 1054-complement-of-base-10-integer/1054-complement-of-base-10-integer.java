class Solution {
    public int bitwiseComplement(int n) {

        if(n == 0)
        {
            return 1;
        }
        
        StringBuilder str = new StringBuilder();

        while(n != 0)
        {
            if((n & 1) == 1)
            {
                str.append('0');
            }
            else
            {
                str.append('1');
            }

            n = n >> 1;
        }

        str.reverse();

        return Integer.parseInt(str.toString(), 2);
    }
}