class Solution {
    public int[] validSequence(String word1, String word2) {
        

        int left = 0;
        int right = 0;

        int n = word1.length();
        int m = word2.length();
        int[] ans = new int[m];
        int[] suff = new int[m];

        int p = n - 1;

        for(int j = m - 1; j >= 0; j--)
        {
            while(p >= 0 && word1.charAt(p) != word2.charAt(j))
            {
                p--;
            }

            if(p < 0)
            {
                suff[j] = -1;
            }
            else
            {
                suff[j] = p;
                p--;
            }
        }
        
        int count = 0;

        while(left < n && right < m)
        {
            if(word1.charAt(left) == word2.charAt(right))
            {
                ans[right] = left;
                left++;
                right++;
            }
            else if(count == 0 && (right == m - 1 || suff[right + 1] > left))
            {
                ans[right] = left;
                left++;
                right++;
                count = 1;
            }
            else
            {
                left++;
            }
        }
        
        if(right < m)
        {
            return new int[]{};
        }
        
        return ans;
    }
}