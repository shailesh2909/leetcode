class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int n = nums.length;
        
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean flag = false;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == target)
            {
                ans.add(i);
                flag = true;
            }
            else if(flag)
            {
                break;
            }
        }

        return ans;
        
    }
}