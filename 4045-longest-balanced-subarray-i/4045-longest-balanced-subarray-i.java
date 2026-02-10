class Solution {
    public int longestBalanced(int[] nums) {
        
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            HashSet<Integer> list = new HashSet<>();
            int j = i;
            int ocnt = 0;
            int ecnt = 0;
            int temp = Integer.MIN_VALUE;

            for(j = i; j < nums.length; j++)
            {
    
                if(nums[j] % 2 == 0 && !list.contains(nums[j]))
                {
                    ecnt++;
                    list.add(nums[j]);
                }

                if(nums[j] % 2 == 1 && !list.contains(nums[j]))
                {
                    ocnt++;
                    list.add(nums[j]);
                }


                if(ecnt == ocnt)
                {
                    temp = Math.max(temp, (j - i) + 1);
                }
           
            }
            
            max = Math.max(max, temp);
   
        }

        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}