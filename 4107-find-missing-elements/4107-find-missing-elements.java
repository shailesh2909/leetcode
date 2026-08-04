class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            set.add(nums[i]);
        }

        for(int i = min + 1; i < max; i++)
        {
            if(!set.contains(i))
            {
                ans.add(i);
            }
        }

        return ans;

    }
}