class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        int lowLen = getLen(low);
        int highLen = getLen(high);

        int originalLow = low;

        while (lowLen <= highLen) {

            int num = generate(lowLen, low);
            int fact = fact(lowLen);

            while (num <= high && getLen(num) == lowLen && num % 10 != 0) {

                if (num >= originalLow)
                    ans.add(num);

                num += fact;
            }

            low = (int) Math.pow(10, lowLen);
            lowLen++;
        }

        return ans;
    }

    public int getLen(int n) {
        return (int) Math.log10(n) + 1;
    }

    public int generate(int n, int low) {

        int x = low / (int) Math.pow(10, n - 1);

        while (x + n - 1 <= 9) {

            int ans = 0;    
            int temp = x;

            for (int i = 1; i <= n; i++) {
                ans = ans * 10 + temp;
                temp++;
            }

            if (ans >= low)
                return ans;

            x++;
        }

        return Integer.MAX_VALUE;
    }

    public int fact(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = ans * 10 + 1;
        }

        return ans;
    }
}