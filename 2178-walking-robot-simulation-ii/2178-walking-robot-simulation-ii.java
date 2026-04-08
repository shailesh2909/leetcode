class Robot {
    String currDir;
    int currPos[];
    int width;
    int height;

    public Robot(int width, int height) {

        this.width = width;
        this.height = height;
        
        currDir = "East";
        currPos = new int[2];

        currPos[0] = 0;
        currPos[1] = 0;
        
    }
    
    public void step(int num) {
        
        int cycle = 2 * (width + height - 2);
        num = num % cycle;

        if (num == 0 && currPos[0] == 0 && currPos[1] == 0) 
        {
            currDir = "South";
            return;
        }

        while (num > 0) 
        {

            if (currDir.equals("East")) 
            {
                if (currPos[1] < width - 1) 
                {
                    currPos[1]++;
                    num--;
                } 
                else 
                {
                    currDir = "North";
                }

            } 
            else if (currDir.equals("North")) 
            {
                if (currPos[0] < height - 1) 
                {
                    currPos[0]++;
                    num--;
                } 
                else 
                {
                    currDir = "West";
                }

            }
            else if (currDir.equals("West")) 
            {
                if (currPos[1] > 0) 
                {
                    currPos[1]--;
                    num--;
                } 
                else 
                {
                    currDir = "South";
                }

            } 
            else
            {
                if (currPos[0] > 0) 
                {
                    currPos[0]--;
                    num--;
                } 
                else 
                {
                    currDir = "East";
                }
            }
        }
        
    }
    
    public int[] getPos() {
        
        return new int[]{currPos[1], currPos[0]};
    }
    
    public String getDir() {
        
        return currDir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */