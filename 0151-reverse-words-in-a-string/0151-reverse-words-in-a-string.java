class Solution {
    public String reverseWords(String s) {
    
        s = s.trim();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == ' ')
            {
                if(count != 0) ans.append(s.substring(i+1, i + count+1)+" ");
                count = 0;
            }
            else
            {
                count++;
            }
        }

        ans.append(s.substring(0, count)+" ");
        return ans.toString().trim();
    }
}