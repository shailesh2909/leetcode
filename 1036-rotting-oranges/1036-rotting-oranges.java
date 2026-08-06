class Pair
{
    int first;
    int second;

    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new Pair(i, j));
                }
                else if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        
        int ans = 0;

        if(fresh == 0)
        {
            return 0;
        }

        int[] rDir = {-1, 1, 0 , 0};
        int[] cDir = {0, 0, -1, 1};

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;

            for(int j = 0; j < size; j++)
            {
                Pair temp = q.poll();

                int row = temp.first;
                int col = temp.second;

                for(int i = 0; i < 4; i++)
                {
                    int nr = row + rDir[i];
                    int nc = col + cDir[i];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1)
                    {
                        flag = true;
                        fresh--;
                        q.offer(new Pair(nr, nc));
                        grid[nr][nc] = 2;
                    }
                }
            }

            if(flag)
            {
                ans++;
            }
        }

        if(fresh == 0)
        {
            return ans;
        }

        return -1;
    }
}