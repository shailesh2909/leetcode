class Solution {
    public long[] distance(int[] nums) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long ans[] = new long[nums.length];

        for(ArrayList<Integer> list : map.values()) 
        {
            int size = list.size();

            long[] prefix = new long[size + 1];

            for(int i = 0; i < size; i++) 
            {
                prefix[i + 1] = prefix[i] + list.get(i);
            }

            for(int i = 0; i < size; i++) 
            {
                int idx = list.get(i);

                long left = (long)i * idx - prefix[i];
                long right = (prefix[size] - prefix[i + 1]) - (long)(size - i - 1) * idx;

                ans[idx] = left + right;
            }
        }

        return ans;
    }
}