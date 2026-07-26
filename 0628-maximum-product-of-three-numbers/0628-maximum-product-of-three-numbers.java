class Solution {
    public int maximumProduct(int[] nums) {
        
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums)
        {
            if(num < min1)
            {
                min2 = min1;
                min1 = num;
            }
            else if(num < min2)
            {
                min2 = num;
            }

            if(num > m1)
            {
                m3 = m2;
                m2 = m1;
                m1 = num;
            }
            else if(num > m2)
            {
                m3 = m2;
                m2 = num;
            }
            else if(num > m3)
            {
                m3 = num;
            }
        }

        return Math.max((m1 * m2 * m3), (min1 * min2 * m1));
    }
}