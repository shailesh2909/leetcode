class Solution {
    public int reverse(int x) {
        
        boolean isSign = false;

        if(x < 0)
        {
            isSign = true;
        }

        int temp = x;
        long ans = 0;

        while(temp != 0)
        {
            int rem = temp % 10;
            ans = (ans * 10) + rem;
            temp = temp / 10;

            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            {
                return 0;
            }
        }

        return (int)ans;
    }
}