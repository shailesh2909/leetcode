class Solution {
    public int maximumLengthSubstring(String s) {

        int n = s.length();
        int[] freq = new int[26];
        int right = 0;
        int left = 0;

        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            freq[s.charAt(i) - 'a']++;

            while(freq[s.charAt(i) - 'a'] > 2)
            {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}