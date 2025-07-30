class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefSum = 0;
        int count = 0;
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++)
        {
            prefSum += nums[i];
            int remove = prefSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }

        return count;
    }
}