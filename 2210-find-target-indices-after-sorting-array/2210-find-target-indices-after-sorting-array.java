class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int left = 0;
        int right = n - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
            {
                int i = mid;

                while(i >= 0 && nums[i] == target)
                {
                    i--;
                }

                i++;

                while(i < n && nums[i] == target)
                {
                    ans.add(i);
                    i++;
                }

                break;
            }

            if(nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
        
    }
}