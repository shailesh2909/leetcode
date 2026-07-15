class Solution {

    public int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }

        return gcd(b, Math.abs(a - b));
    }
    public int gcdOfOddEvenSums(int n) {
        
        return n;
    }
}