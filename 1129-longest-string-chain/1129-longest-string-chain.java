class Solution {

    public boolean compare(String s1, String s2)
    {
        if(s1.length() != s2.length() + 1) return false;

        int i = 0;
        int j = 0;

        while(i < s1.length())
        {
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }

        if(i == s1.length() && j == s2.length())
        {
            return true;
        }

        return false;
    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int dp[] = new int[n];

        int max = 1;

        for(int i = 0; i < n; i++)
        {
            dp[i] = 1;
            for(int prev = 0; prev < i; prev++)
            {
                if(compare(words[i], words[prev]) && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                }
            }

            if(dp[i] > max)
            {
                max = dp[i];
            }
        }

        return max;
        
    }
}