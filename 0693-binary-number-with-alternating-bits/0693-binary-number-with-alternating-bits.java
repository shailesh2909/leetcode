class Solution {
    public boolean hasAlternatingBits(int n) {
        String stream = Integer.toBinaryString(n);

        for(int i = 0; i< stream.length() - 1; i++)
        {
            if(stream.charAt(i) == stream.charAt(i + 1))
            {
                return false;
            }
        }

        return true;
    }
}