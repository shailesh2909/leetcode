class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < nums.length; i++)
        {
            ArrayList<Integer> list =  map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) 
        {
            ArrayList<Integer> list = map.get(nums[q]);

            if (list.size() == 1) 
            {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, q);

            int next = list.get((pos + 1) % list.size());
            int prev = list.get((pos - 1 + list.size()) % list.size());

            int d1 = Math.abs(next - q);
            int d2 = Math.abs(prev - q);

            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);

            ans.add(Math.min(dist1, dist2));
        }

        return ans;

    }
}