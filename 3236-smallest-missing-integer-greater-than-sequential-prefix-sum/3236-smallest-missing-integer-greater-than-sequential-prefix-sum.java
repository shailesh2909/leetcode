class Solution {
    public int missingInteger(int[] nums) {
        
        int n = nums.length;
        
        int sum = nums[0];
        int ind = 0;

        for(int i = 1; i < n; i++)
        {
            if(nums[i] == nums[i - 1] + 1)
            {
                sum += nums[i];
                ind++;
            }
            else
            {
                break;
            }
        }

        System.out.println(sum);
        System.out.println(ind);

        int curr = sum;

        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums)
        {
            set.add(ele);
        }

        while(set.contains(curr))
        {
            curr++;
        }

        return curr;
    }
}