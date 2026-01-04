class Solution {
    public int sumFourDivisors(int[] nums) {

        int sum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int sum1 = 0;
            int count = 0;

            for(int j = 1; j <=Math.sqrt(nums[i]); j++)
            {
                if(nums[i] % j == 0)
                {
                    if(j * j == nums[i])
                    {
                        count += 1;
                        sum1 += j;
                    }
                    else
                    {
                        count += 2;
                        
                        sum1 += j + (nums[i] / j);
                    }
                    
                }
            }

            if(count == 4)
            {
                sum += sum1;
                count = 0;
                sum1 = 0;
            }
        }

        return sum;
    }
}