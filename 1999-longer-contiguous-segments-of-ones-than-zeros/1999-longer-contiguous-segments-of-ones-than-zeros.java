class Solution {
    public boolean checkZeroOnes(String s) {
        
        int cnt1 = 0;
        int cnt0 = 0;
        int a = 0, b = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
            {
                a = Math.max(a, cnt0);
                cnt0 = 0;
                cnt1++;
            }
            else
            {
                b = Math.max(b, cnt1);
                cnt1 = 0;
                cnt0++;
            }
        }
        
        b = Math.max(cnt1, b);
        a = Math.max(cnt0, a);
        return (b > a);
    }
}