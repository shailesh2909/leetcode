class Solution {
    public int maxGoodNumber(int[] nums) {
        
        String a = Integer.toBinaryString(nums[0]);
        String b = Integer.toBinaryString(nums[1]);
        String c = Integer.toBinaryString(nums[2]);

        String[] arr = {
            a+b+c,
            a+c+b,
            b+a+c,
            b+c+a,
            c+a+b,
            c+b+a
        };

        int max = 0;

        for(String s : arr) 
        {
            int val = Integer.parseInt(s, 2);
            max = Math.max(max, val);
        }

        return max;
    }
}