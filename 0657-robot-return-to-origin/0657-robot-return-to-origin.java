class Solution {
    public boolean judgeCircle(String moves) {
        
        int l = 0;
        int r = 0;
        int u = 0;
        int d = 0;

        for(int i = 0; i < moves.length(); i++)
        {
            if(moves.charAt(i) == 'L')
            {
                l++;
            }
            else if(moves.charAt(i) == 'D')
            {
                d++;
            }
            else if(moves.charAt(i) == 'R')
            {
                r++;
            }
            else
            {
                u++;
            }
        }

        if(l == r && u == d)
        {
            return true;
        }

        return false;
    }
}