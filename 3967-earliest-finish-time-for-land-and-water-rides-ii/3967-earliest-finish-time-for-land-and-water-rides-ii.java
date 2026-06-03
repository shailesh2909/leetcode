class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int[] landFinish = new int[n];
        int[] waterFinish = new int[m];

        for (int i = 0; i < n; i++) {
            landFinish[i] = landStartTime[i] + landDuration[i];
        }

        for (int i = 0; i < m; i++) {
            waterFinish[i] = waterStartTime[i] + waterDuration[i];
        }

        Arrays.sort(landFinish);
        Arrays.sort(waterFinish);

        long ans = Long.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            int ws = waterStartTime[j];
            int wd = waterDuration[j];

            int idx = upperBound(landFinish, ws);

            if (idx > 0) {
                ans = Math.min(ans, (long) ws + wd);
            }

            if (idx < n) {
                ans = Math.min(ans, (long) landFinish[idx] + wd);
            }
        }

        for (int i = 0; i < n; i++) {
            int ls = landStartTime[i];
            int ld = landDuration[i];

            int idx = upperBound(waterFinish, ls);

            if (idx > 0) {
                ans = Math.min(ans, (long) ls + ld);
            }

            if (idx < m) {
                ans = Math.min(ans, (long) waterFinish[idx] + ld);
            }
        }

        return (int) ans;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}