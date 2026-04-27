class Solution {
    private final int[][][] directions = {
        {}, 
        {{0, -1}, {0, 1}},  
        {{-1, 0}, {1, 0}},  
        {{0, -1}, {1, 0}},  
        {{0, 1}, {1, 0}},   
        {{0, -1}, {-1, 0}}, 
        {{0, 1}, {-1, 0}}   
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            int streetType = grid[r][c];
            for (int[] dir : directions[streetType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (canConnect(r, c, nr, nc, grid)) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }

    private boolean canConnect(int r, int c, int nr, int nc, int[][] grid) {
        int targetStreet = grid[nr][nc];
        for (int[] backDir : directions[targetStreet]) {
            if (nr + backDir[0] == r && nc + backDir[1] == c) {
                return true;
            }
        }
        return false;
    }
}