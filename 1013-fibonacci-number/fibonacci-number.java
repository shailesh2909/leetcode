class Solution {
    public int fib(int n) {
        if(n<=1)
        {
            return n;
        }

        int fst = fib(n-1);
        int scnd = fib(n-2);

        return fst + scnd;
    }
}