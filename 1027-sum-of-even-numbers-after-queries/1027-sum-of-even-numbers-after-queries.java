class Solution {

    public static int findSum(int arr[])
    {
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                sum += arr[i];
            }
        }

        return sum;
    }
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int arr[] = new int[queries.length];
        int sum = 0;

        for(int i = 0; i < queries.length; i++)
        {
            sum = nums[queries[i][1]] + queries[i][0];
            nums[queries[i][1]] = sum;
            arr[i] = findSum(nums);
            sum = 0;
        }

        return arr;
    }
}