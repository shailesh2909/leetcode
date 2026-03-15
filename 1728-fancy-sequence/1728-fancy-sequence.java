class Fancy {

    ArrayList<Long> list;
    long MOD = 1000000007L;
    long mul;
    long add;

    public Fancy() {
        list = new ArrayList<>();

        mul = 1;
        add = 0;
    }
    
    public void append(int val) {
        
        long x = ((val - add) + MOD) % MOD;
        x = (x * modInverse(mul)) % MOD;

        list.add(x);
    }
    
    public void addAll(int inc) {
        
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
    
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {

        if(idx >= list.size())
        {
            return -1;
        }
        
        long x = list.get(idx);
        x = (x * mul) % MOD;
        x = (x + add) % MOD;

        return (int)x;
    }

    public long modInverse(long x)
    {
        return power(x, MOD - 2);
    }

    public long power(long a, long b)
    {
        long res = 1;

        a %= MOD;

        while(b > 0)
        {
            if((b & 1) == 1)
            {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b = b >> 1;
        }

        return res;

    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */