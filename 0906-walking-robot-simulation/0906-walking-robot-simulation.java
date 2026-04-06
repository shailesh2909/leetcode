class Solution {

    public int[] check(int[][] obstacles, int x, int y)
    {
        for(int i = 0; i < obstacles.length; i++)
        {
            int ox = obstacles[i][0];
            int oy = obstacles[i][1];

            if (ox <= x && oy <= y) 
            {
                return new int[]{ox, oy};
            }
        }

        return new int[]{0, 0};
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        
        int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int direction = 0;
        int[] ans = new int[2];

        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) 
        {
            set.add(o[0] + "," + o[1]);
        }

        int maxDist = 0;

        for (int i = 0; i < commands.length; i++) 
        {

            if (commands[i] == -2) 
            {
                direction = (direction + 3) % 4;
            }
            else if (commands[i] == -1) 
            {
                direction = (direction + 1) % 4;
            }
            else 
            {
                for (int step = 0; step < commands[i]; step++) 
                {

                    int newX = ans[0] + dir[direction][0];
                    int newY = ans[1] + dir[direction][1];

                    if (set.contains(newX + "," + newY)) 
                    {
                        break;
                    }

                    ans[0] = newX;
                    ans[1] = newY;

                    maxDist = Math.max(maxDist, ans[0]*ans[0] + ans[1]*ans[1]);
                }
            }
        }

        return maxDist;
    }
}