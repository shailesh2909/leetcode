class Solution {
    public boolean search(int[] nums, int target) {
        
        List<Integer> temp = new ArrayList<>();

        for(int n : nums)
        {
            temp.add(n);
        }

        if(temp.contains(target))
        {
            return true;
        }

        return false;
    }
}