class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
     
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 3L * side - x;
            else pos[i] = 4L * side - y;
        }

        Arrays.sort(pos);

        long low = 1, high = side; 
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (can(pos, n, k, mid, side)) {
                ans = mid;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean can(long[] pos, int n, int k, long d, int side) {
        long perimeter = 4L * side;
        
        long[] extPos = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extPos[i] = pos[i];
            extPos[i + n] = pos[i] + perimeter;
        }

        int[] nxt = new int[2 * n];
        int j = 0;
        for (int i = 0; i < 2 * n; i++) {
            while (j < 2 * n && extPos[j] - extPos[i] < d) {
                j++;
            }
            nxt[i] = j;
        }

        for (int i = 0; i < n; i++) {
            int curr = i;
            boolean possible = true;
            
            for (int step = 1; step < k; step++) {
                curr = nxt[curr];
                if (curr >= 2 * n) { 
                    possible = false;
                    break;
                }
            }
           
            if (possible && (extPos[curr] - extPos[i] <= perimeter - d)) {
                return true;
            }
        }

        return false;
    }
}