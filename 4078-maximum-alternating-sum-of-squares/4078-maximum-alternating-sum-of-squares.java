class Solution {
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;
        long arr[] = new long[n];

        for(int i = 0; i < n; i++) 
        {
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long sum = 0;

        for(int i = n / 2; i < n; i++) 
        {
            sum += arr[i];
        }

        for(int i = 0; i < n / 2; i++) 
        {
            sum -= arr[i];
        }

        return sum;
    }
}