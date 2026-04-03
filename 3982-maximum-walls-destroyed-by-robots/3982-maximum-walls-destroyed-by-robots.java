class Solution {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = robots.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] num = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        for (int i = 0; i < n; i++) {

            int pos1 = upperBound(walls, robots[i]);

            int leftStart;

            if (i > 0) {
                leftStart = Math.max(
                        robots[i] - map.get(robots[i]),
                        robots[i - 1] + 1
                );
            } else {
                leftStart = robots[i] - map.get(robots[i]);
            }

            int leftIndex = lowerBound(walls, leftStart);
            left[i] = pos1 - leftIndex;

            int rightEnd;

            if (i < n - 1) {
                rightEnd = Math.min(
                        robots[i] + map.get(robots[i]),
                        robots[i + 1] - 1
                );
            } else {
                rightEnd = robots[i] + map.get(robots[i]);
            }

            int rightIndex = upperBound(walls, rightEnd);
            int start = lowerBound(walls, robots[i]);

            right[i] = rightIndex - start;

            if (i > 0) {
                int prev = lowerBound(walls, robots[i - 1]);
                num[i] = pos1 - prev;
            }
        }

        int subLeft = left[0];
        int subRight = right[0];

        for (int i = 1; i < n; i++) {

            int currentLeft = Math.max(
                    subLeft + left[i],
                    subRight - right[i - 1] +
                            Math.min(left[i] + right[i - 1], num[i])
            );

            int currentRight = Math.max(
                    subLeft + right[i],
                    subRight + right[i]
            );

            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}