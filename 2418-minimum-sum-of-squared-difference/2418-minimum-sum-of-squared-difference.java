class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int diff[] = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long sum = 0;
        for(int num : diff) {
            sum += num;
        }

        if(sum <= k) return 0;

        int left = 0;
        int right = max;

        while(left < right) {
            int mid = left + (right - left) / 2;
            long operations = 0;

            for(int num : diff) {
                if(num > mid) {
                    operations += num - mid;
                }
            }

            if(operations <= k) right = mid;
            else left = mid + 1;
        }

        long ans = 0;
        long remaining = k;

        for(int num : diff) {
            if(num > left) {
                remaining -= num - left;
                num = left;
            }
            ans += (long) num * num;
        }

        for(int i = 0; i < n && remaining > 0; i++) {
            if(diff[i] >= left && left > 0) {
                ans -= (long) left * left;
                ans += (long) (left - 1) * (left - 1);
                remaining--;
            }
        }

        return ans;
    }
}