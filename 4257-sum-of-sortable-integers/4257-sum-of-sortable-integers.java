class Solution {
    public int sortableIntegers(int[] nums) {

        int n = nums.length;
        int arr[] = nums.clone();
        Arrays.sort(arr);

        int ans = 0;
        int freq[] = new int[100001];

        for(int k = 1; k <= n; k++) {

            if(n % k != 0) continue;

            boolean valid = true;

            for(int i = 0; i < n; i += k) {

                int count = 0;

                for(int j = i; j < i + k; j++) {
                    freq[nums[j]]++;
                    freq[arr[j]]--;
                }

                for(int j = i; j < i + k; j++) {
                    if(freq[nums[j]] != 0 || freq[arr[j]] != 0) {
                        valid = false;
                    }

                    freq[nums[j]] = 0;
                    freq[arr[j]] = 0;
                }

                for(int j = i; j < i + k; j++) {
                    int next = i + (j - i + 1) % k;

                    if(nums[j] > nums[next]) {
                        count++;
                    }
                }

                if(count > 1) {
                    valid = false;
                }

                if(!valid) break;
            }

            if(valid) ans += k;
        }

        return ans;
    }
}