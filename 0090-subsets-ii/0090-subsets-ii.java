class Solution {

    void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(output));

        for(int i = index; i < nums.length; i++) 
        {

            if(i > index && nums[i] == nums[i - 1]) 
                continue;

            output.add(nums[i]);
            solve(nums, i + 1, output, res);
            output.remove(output.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
 

        solve(nums, 0, new ArrayList<>(), res);
        return res;
    }
}