class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int m = grid[0].length;
        int n = grid.length;

        int ans[][] = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                ans[i][j] = grid[i][j];
            }
        }

        int top = x;
        int bottom = x + k - 1;

        while(top < bottom)
        {
            for(int i = y; i < y + k; i++)
            {
                int temp = ans[top][i];
                ans[top][i] = ans[bottom][i];
                ans[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        return ans;
        
    }
}