class Solution {
    public boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;

        while (n != 0) {
            int rem = n % 10;
            if(rem>=0)
            {
                rev = rev * 10 + rem;
                n = n / 10;
            }
            else
            {
                return false;
            }
        }

        if(temp==rev)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}