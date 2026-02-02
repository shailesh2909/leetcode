class Solution {
    public double minimumAverage(int[] nums) {

        for(int i = 0; i < nums.length - 1; i++)
        {
            int j = i;

            while(j >= 0 && nums[j + 1] < nums[j])
            {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                j--;
            }
        }
        
        int i = 0; 
        int j = nums.length - 1;

        double ans = Double.MAX_VALUE;

        while(i < j)
        {
            double temp = (double)(nums[i] + nums[j])/2;
            ans = Math.min(temp, ans);
            j--;
            i++;
        }

        return ans;
    }
}