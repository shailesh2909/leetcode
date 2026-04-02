class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int arr[] = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++)
        {
            arr[nums[i]]++;
        }

        int missing = -1;
        int duplicate = -1;

        for(int i = 1; i <= nums.length; i++)
        {
            if(arr[i] == 2)
            {
                duplicate = i;
            }

            if(arr[i] == 0)
            {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}