class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int count = 0;
        int blank = 0;

        for(int i = 0; i < moves.length(); i++)
        {
            if(moves.charAt(i) == 'L')
            {
                count--;
            }
            else if(moves.charAt(i) == 'R')
            {
                count++;
            }
            else
            {
                blank++;
            }
        }

        return Math.abs(count) + blank;

    }
}