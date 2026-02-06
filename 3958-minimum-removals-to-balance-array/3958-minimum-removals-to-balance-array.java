class Solution {
    int upperBound(int[] arr, long target) {

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
        
        return low;
    }

    public int minRemoval(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = n - 1;

        for(int i = 0; i < n; i++)
        {
            long curr = (long)nums[i] * k;
            int ind = upperBound(nums, curr);

            int rcnt = n - ind;
            int lcnt = i;

            cnt = Math.min(cnt, rcnt + lcnt);
        }
        return cnt;
    }
}