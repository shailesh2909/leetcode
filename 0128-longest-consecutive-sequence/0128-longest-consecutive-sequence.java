class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }

        if(nums.length == 1)
        {
            return 1;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int cnt = 0;
                int curr = num;
                while(set.contains(curr + 1))
                {
                    cnt++;
                    curr++;
                }
                ans = Math.max(ans, cnt);
            }
        }

        return ans+1;
    }
}