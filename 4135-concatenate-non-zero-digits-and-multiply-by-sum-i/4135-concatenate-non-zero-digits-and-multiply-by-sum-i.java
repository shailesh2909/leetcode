class Solution {
    public long sumAndMultiply(int n) {
        
        int num = n;

        int sum = 0;
        int x = 0;

        while(num != 0)
        {
            int rev = num % 10;
            if(rev != 0)
            {
                x = x*10 + rev;
                sum += rev;
            }
            num = num / 10;
        }

        int temp = 0;

        while(x != 0)
        {
            int rev = x % 10;
            temp = temp*10 + rev;
            x = x / 10;
        }

        return (long) temp * sum;
    }
}