class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int ans = 0;

        int[][] prefix = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                prefix[i][j] += grid[i][j];

                if(i > 0)
                {
                    prefix[i][j] += prefix[i - 1][j];
                }
                if(j > 0)
                {
                    prefix[i][j] += prefix[i][j - 1];
                }
                if(i > 0 && j > 0)
                {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }

                if(prefix[i][j] <= k)
                {
                    ans++;
                }
            }
        }

        return ans;
    }
}