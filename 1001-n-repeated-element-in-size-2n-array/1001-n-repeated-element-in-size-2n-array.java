class Solution {
    public int repeatedNTimes(int[] nums) {
       
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(arr.contains(nums[i]))
            {
                return nums[i];
            }

            arr.add(nums[i]);
        }

        return 0;

    }
}