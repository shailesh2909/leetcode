class Solution {

    public int lower_bound(ArrayList<Integer> arr, int ele)
    {
        int low = 0;
        int high = arr.size();

        while(low < high)
        {
            int mid = low + (high - low) / 2;

            if(arr.get(mid) >= ele)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > temp.get(temp.size() - 1))
            {
                temp.add(nums[i]);
                len++;
            }
            else
            {
                int ind = lower_bound(temp, nums[i]);
                temp.set(ind, nums[i]);
            }
        }

        return len;
        
    }
}