class Cell 
{
    int row;
    int col;
    int height;

    Cell(int row, int col, int height) 
    {
        this.row = row;
        this.col = col;
        this.height = height;
    }    
}
class Solution {
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3)
            return 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) 
        {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));

            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) 
        {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));

            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        int water = 0;

        while (!pq.isEmpty()) 
        {
            Cell curr = pq.poll();

            for (int[] d : dir) 
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                water += Math.max(0, curr.height - heightMap[nr][nc]);

                pq.offer(new Cell(nr, nc, Math.max(curr.height, heightMap[nr][nc])));
            }
        }

        return water;
    }
}