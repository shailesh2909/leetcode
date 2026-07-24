class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) 
        {
            arr[i][0] = nums[i];  
            arr[i][1] = i;         
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        Arrays.sort(nums);

        int ans[] = new int[2];

        int left = 0;
        int right = nums.length - 1;
        

        while(left < right)
        {
            int sum = nums[left] + nums[right];

            if(sum == target)
            {
                ans[0] = arr[left][1];
                ans[1] = arr[right][1];
                return ans;
            }
            else if(sum > target)
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return ans;
    }
}