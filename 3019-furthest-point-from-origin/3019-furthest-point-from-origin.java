class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int l = 0, r = 0, u = 0;

        for(int i = 0; i < moves.length(); i++)
        {
            char c = moves.charAt(i);

            if(c == 'L') l++;
            else if(c == 'R') r++;
            else u++;
        }

        return Math.abs(r - l) + u;

    }
}