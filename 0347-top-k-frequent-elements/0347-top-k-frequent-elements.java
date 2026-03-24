class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : nums)
        {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.offer(entry);

            if (pq.size() > k) 
            {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) 
        {
            res[i] = pq.poll().getKey();
            i++;
        }

        return res;
    }
}