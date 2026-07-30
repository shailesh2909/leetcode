class Solution {
    public int minimumPushes(String word) {
        
        int len = word.length();

        if(len <= 8)
        {
            return len;
        }

        if(len <= 16)
        {
            return 8 + (len - 8) * 2;
        }

        if(len <= 24)
        {
            return 24 + (len - 16) * 3;
        }

        return 48 + (len - 24) * 4;
    }
}