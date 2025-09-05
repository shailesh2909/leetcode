class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() > goal.length() || goal.length() > s.length())
        {
            return false;
        }

        StringBuilder temp = new StringBuilder(s+s);
        if(temp.indexOf(goal) == -1)
        {
            return false;
        }

        return true;
    }
}