class Solution {

    public int gcd(int a, int b)
    {
        while(b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int lcm(int a, int b)
    {
        return (a/(gcd(a, b)) * b);
    }

    public int maxLength(int[] nums) {
        
        int ans = 0;

        

        for(int i = 0; i < nums.length; i++)
        {
            int prod = nums[i];
            int gcd = nums[i];
            int lcm = nums[i];
            for(int j = i + 1; j < nums.length; j++)
            {
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                prod *= nums[j];

                if(prod == gcd*lcm)
                {
                    ans = Math.max(ans, j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }

        return ans;
    }
}