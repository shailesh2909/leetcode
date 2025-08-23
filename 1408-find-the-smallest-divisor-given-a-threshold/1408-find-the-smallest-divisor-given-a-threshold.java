class Solution {

    public static int sumD(int arr[], int div)
    {
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            sum = sum + (int)Math.ceil((double)arr[i] / (double)div);
        }

        return sum;
    }
    public int smallestDivisor(int[] arr, int threshold) {
        
        int low = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
        }

        int high = max;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(sumD(arr, mid) <= threshold)
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