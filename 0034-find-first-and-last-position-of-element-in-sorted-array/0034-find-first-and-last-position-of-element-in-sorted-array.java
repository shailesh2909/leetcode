class Solution {

    public static int upperBound(int[] arr, int target) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            if(arr[mid] > target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public static int lowerBound(int[] arr, int target) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {

        int ans[] = new int[2];
        
        int lb = lowerBound(nums, target);

        if(lb == nums.length || nums[lb] != target)
        {
            ans[0] = -1;
            ans[1] = -1;
        }
        else
        {
            ans[0] = lb;
            ans[1] = upperBound(nums, target) - 1;
        }

        return ans;
    }
}