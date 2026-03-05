class Solution {
    public int minOperations(String str) {
        
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != '0' && i % 2 == 0)
            {
                ++a1;
            }
            else if(str.charAt(i) != '1' && i % 2 == 0)
            {
               ++b1;
            }

            if(str.charAt(i) != '0' && i % 2 == 1)
            {
                b2++;
            }
            else if(str.charAt(i) != '1' && i % 2 == 1)
            {
                a2++;
            }
        }

        return Math.min((a1 + a2), (b1 + b2));
    }
}