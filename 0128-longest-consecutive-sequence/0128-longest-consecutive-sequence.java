class Solution {
    public int longestConsecutive(int[] nums) {
        
        int count = 1;
        int ans = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int e : nums)
        {
            set.add(e);
        }

        for(int e : set)
        {
            if(!set.contains(e - 1))
            {
                count = 1;

                while(set.contains(e + 1))
                {
                    count++;
                    e++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}