class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        long curr = 0, max = 0;

        int left = 0;
        for(int right = 0; right < nums.length; right++)
        {
            while(set.contains(nums[right]) || set.size() == k)
            {
                set.remove(nums[left]);
                curr -= nums[left];
                left++;
            }
            curr += nums[right];
            set.add(nums[right]);

            if(set.size() == k)
            {
                max = Math.max(curr, max);
            }
        }

        return max;
    }
}