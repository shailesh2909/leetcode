class Solution {
    public int countTriples(int n) {
        
         int count = 0;

        for (int c = 1; c <= n; c++) {
            int c2 = c * c;
            for (int a = 1; a < c; a++) {
                int b2 = c2 - a * a;
                int b = (int) Math.sqrt(b2);

                if (b * b == b2 && b <= n) {
                    count++;
                }
            }
        }
        return count;
    }
}