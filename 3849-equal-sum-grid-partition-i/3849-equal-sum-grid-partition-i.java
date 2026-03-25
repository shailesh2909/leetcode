class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        
        long total = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                total += grid[i][j];
            }
        }

        long row = 0;
        long col = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                row += grid[i][j];
            }

            if(row == total / 2)
            {
                return true;
            }
            else if(row > total / 2)
            {
                row = 0;   
            }
        }

        for(int i = 0; i < grid[0].length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                col += grid[j][i];
            }

            if(col == total / 2)
            {
                return true;
            }
            else if(col > total / 2)
            {
                col = 0;   
            }
        }

        return false;
    }
}