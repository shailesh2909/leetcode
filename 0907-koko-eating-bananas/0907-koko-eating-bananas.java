class Solution {

    public static int findMax(int[] arr)
    {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i< arr.length; i++)
        {
            ans = Math.max(ans, arr[i]);
        }

        return ans;
    }

    public static int calHours(int arr[], int h)
    {
        int totalH = 0;

        for(int i = 0; i<arr.length; i++)
        {
            totalH += Math.ceil((double)arr[i] / (double)h);
        }

        return totalH;
    }
    public int minEatingSpeed(int[] arr, int h) {
        
        int low = 1;
        int high = findMax(arr);

        while(low <= high)
        {
            int mid = (low + high) / 2;

            int totalH = calHours(arr, mid);

            if(totalH <= h)
            {
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