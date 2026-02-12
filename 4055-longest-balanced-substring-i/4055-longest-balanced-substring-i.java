class Solution {
    public int longestBalanced(String s) {

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++)
        {
            int[] freq = new int[26];
            
            for(int j = i; j < s.length(); j++)
            {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int k = 0; k < 26; k++)
                {
                    if(freq[k] > 0)
                    {
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }

                if(min == max)
                {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        
        return ans;
    }
}