class Solution {
    public static int findDays(int arr[], int cap)
    {
        int days = 1;
        int load = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if((arr[i] + load) > cap)
            {
                days = days + 1;
                load = arr[i];
            }
            else
            {
                load += arr[i];
            }
        }

        return days;
    }

    public int shipWithinDays(int[] arr, int days) {
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = 0;

        for(int i = 0; i < arr.length; i++)
        {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(findDays(arr, mid) <= days)
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
}