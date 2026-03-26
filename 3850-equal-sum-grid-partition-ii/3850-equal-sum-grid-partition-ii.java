class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        long total = 0;
        for (int[] row : grid) {
            for (int v : row) total += v;
        }

        HashMap<Integer, Integer> right = new HashMap<>();
        for (int[] row : grid) {
            for (int v : row) {
                right.put(v, right.getOrDefault(v, 0) + 1);
            }
        }

        HashMap<Integer, Integer> left = new HashMap<>();
        long sum = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                sum += v;
                left.put(v, left.getOrDefault(v, 0) + 1);
                right.put(v, right.get(v) - 1);
                if (right.get(v) == 0) right.remove(v);
            }

            long other = total - sum;
            if (sum == other) return true;

            long diff = Math.abs(sum - other);

            if (sum > other) {
                if (check(left, diff, i + 1, m, grid, 0, i, 0, m - 1)) return true;
            } else {
                if (check(right, diff, n - i - 1, m, grid, i + 1, n - 1, 0, m - 1)) return true;
            }
        }

        left.clear();
        right.clear();
        sum = 0;

        for (int[] row : grid) {
            for (int v : row) {
                right.put(v, right.getOrDefault(v, 0) + 1);
            }
        }

     
        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                int v = grid[i][j];
                sum += v;
                left.put(v, left.getOrDefault(v, 0) + 1);
                right.put(v, right.get(v) - 1);
                if (right.get(v) == 0) right.remove(v);
            }

            long other = total - sum;
            if (sum == other) return true;

            long diff = Math.abs(sum - other);

            if (sum > other) {
                if (check(left, diff, n, j + 1, grid, 0, n - 1, 0, j)) return true;
            } else {
                if (check(right, diff, n, m - j - 1, grid, 0, n - 1, j + 1, m - 1)) return true;
            }
        }

        return false;
    }

    private boolean check(HashMap<Integer, Integer> map, long diff,
                          int rows, int cols,
                          int[][] grid,
                          int r1, int r2, int c1, int c2) {

        if (diff > 100000) return false;              
        if (!map.containsKey((int) diff)) return false;

        if (rows == 1) return grid[r1][c1] == diff || grid[r1][c2] == diff;
        if (cols == 1) return grid[r1][c1] == diff || grid[r2][c1] == diff;

        return true;
    }
}