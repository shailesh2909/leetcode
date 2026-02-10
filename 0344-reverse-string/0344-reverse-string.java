class Solution {

    public void reverse(char[] s, int i, int n)
    {
        if(i >= (n / 2))
        {
            return;
        }

        System.out.println(i);
        System.out.println(n - i - 1);

        char temp = s[i];
        s[i] = s[n - i - 1];
        s[n - i - 1] = temp;

        i++;

        reverse(s,i,n);
    }
    public void reverseString(char[] s) {
        
        reverse(s, 0, s.length);
    }
}