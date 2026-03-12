class Solution {
    public boolean isPalindrome(String s) {
        
        String fil = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = fil.length() - 1;

        while(left < right)
        {
            if(fil.charAt(left) != fil.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}