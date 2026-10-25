class Solution {

    public boolean dfs(int i, int j, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }

        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean up = dfs(i - 1, j, grid);
        boolean down = dfs(i + 1, j, grid);
        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid);

        return up && down && left && right;
    }

    public int closedIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 0) {
                    if(dfs(i, j, grid)) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}