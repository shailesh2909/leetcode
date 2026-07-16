class Solution {

    public int gcd(int a, int b)
    {
        while (b != 0) 
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int pref[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, nums[i]);
            pref[i] = gcd(max, nums[i]);
        }

        Arrays.sort(pref);

        int left = 0;
        int right = n - 1;
        long sum = 0;

        while(left < right)
        {
            sum += gcd(pref[left], pref[right]);
            left++;
            right--;
        }

        return sum;
    }
}