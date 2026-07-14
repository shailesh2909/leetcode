class Solution {
    public void nextPermutation(int[] nums) {
        
        int br = -1;

        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] < nums[i+1])
            {
                br = i;
            }
        }

        if(br == -1)
        {
            reverse(nums, 0);
        }
        else
        {
            int gr = br;

            for(int i = nums.length - 1; i > br; i--)
            {
                if(br != -1 && nums[i] > nums[br])
                {
                    gr = i;
                    break;
                }
            }
        
            int temp = nums[br];
            nums[br] = nums[gr];
            nums[gr] = temp;
        
            reverse(nums, br+1);

        }
        
    }

    public void reverse(int[] arr, int start)
    {
        int left = start;
        int right = arr.length - 1;

        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
}