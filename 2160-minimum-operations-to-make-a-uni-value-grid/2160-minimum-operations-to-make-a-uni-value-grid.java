class Solution {
    public int minOperations(int[][] grid, int x) {
        
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                temp.add(grid[i][j]);
            }
        }

        Collections.sort(temp);
        
        int ans = 0;

        int mid = temp.size() / 2;

        for(int i = 0; i < temp.size(); i++)
        {
               int steps = Math.abs(temp.get(i) - temp.get(mid)); 

               if(steps % x != 0)
               {
                    return -1;
               }
               else
               {
                    ans += steps / x;
               }
        }

        return ans;
    }
}