class Solution {
    public int maxDepth(String s) {
        

        if(s.length() == 1)
        {
            return 0;
        }

        int count = 0;
        int count1 = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                count++;
                ans = Math.max(ans, count);
            }

            else if(s.charAt(i) == ')')
            {
                count--;
            }

            else
            {
                count1++;
            }

        }

        if(count1 == s.length())
        {
            return 0;
        }

        return ans;
    }
}