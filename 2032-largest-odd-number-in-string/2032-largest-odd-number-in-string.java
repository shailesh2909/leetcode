class Solution {
    public String largestOddNumber(String s) {
        
        for(int i = s.length() - 1; i >= 0; i--)
        {
            int digit = s.charAt(i) - '0';
            if(digit % 2 == 1)
            {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }
}