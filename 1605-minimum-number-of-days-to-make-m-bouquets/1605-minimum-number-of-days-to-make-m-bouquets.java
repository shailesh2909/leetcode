class Solution {

    public static boolean possible(int arr[], long day, int m, int k) {
        int count = 0;
        int noB = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
                if (count == k) {
                    noB++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return noB >= m;
    }

    public int minDays(int[] arr, int m, int k) {
        if ((long) m * k > arr.length) {
            return -1;
        }

        long maxi = Integer.MIN_VALUE;
        long mini = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        long low = mini;
        long high = maxi;
        long ans = -1;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (possible(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}
