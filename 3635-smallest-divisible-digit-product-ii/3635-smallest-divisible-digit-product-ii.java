class Solution {

    int[][] cnt = new int[10][4];
    {
        cnt[2] = new int[]{1,0,0,0};
        cnt[3] = new int[]{0,1,0,0};
        cnt[4] = new int[]{2,0,0,0};
        cnt[5] = new int[]{0,0,1,0};
        cnt[6] = new int[]{1,1,0,0};
        cnt[7] = new int[]{0,0,0,1};
        cnt[8] = new int[]{3,0,0,0};
        cnt[9] = new int[]{0,2,0,0};
    
    }

    int[][][][] memo;

    int minDigits(int a, int b, int c, int d) 
    {
        if (a < 0) a = 0;
        if (b < 0) b = 0;
        if (c < 0) c = 0;
        if (d < 0) d = 0;
        if (a == 0 && b == 0 && c == 0 && d == 0) return 0;
        if (memo[a][b][c][d] != -1) return memo[a][b][c][d];
        int best = Integer.MAX_VALUE;
        for(int digit = 2; digit <= 9; digit++)
        { 
            int na = a - cnt[digit][0];
            int nb = b - cnt[digit][1];
            int nc = c - cnt[digit][2];
            int nd = d - cnt[digit][3];
            int cna = Math.max(0, na), cnb = Math.max(0, nb), cnc = Math.max(0, nc), cnd = Math.max(0, nd);
     
            if (cna == a && cnb == b && cnc == c && cnd == d) continue;
            int sub = minDigits(na, nb, nc, nd);
            if (sub + 1 < best) best = sub + 1;
        }
        memo[a][b][c][d] = best;
        return best;
    }


    private void appendGreedy(StringBuilder sb, int r2, int r3, int r5, int r7, int length) {
        
        for(int pos = 0; pos < length; pos++) 
        {
            int remaining = length - pos - 1;
            for(int dig = 1; dig <= 9; dig++) 
            {
                int nr2 = r2 - cnt[dig][0];
                int nr3 = r3 - cnt[dig][1];
                int nr5 = r5 - cnt[dig][2];
                int nr7 = r7 - cnt[dig][3];
                if(minDigits(nr2, nr3, nr5, nr7) <= remaining) 
                {
                    sb.append((char) ('0' + dig));
                    r2 = nr2; r3 = nr3; r5 = nr5; r7 = nr7;
                    break;
                }
            }
        }
    }

    public String smallestNumber(String num, long t) {
        long x = t;
        int N2 = 0, N3 = 0, N5 = 0, N7 = 0;
        while (x % 2 == 0) { N2++; x /= 2; }
        while (x % 3 == 0) { N3++; x /= 3; }
        while (x % 5 == 0) { N5++; x /= 5; }
        while (x % 7 == 0) { N7++; x /= 7; }
        if (x > 1) return "-1"; 

        memo = new int[N2 + 1][N3 + 1][N5 + 1][N7 + 1];
        for(int[][][] a1 : memo)
            for(int[][] a2 : a1)
                for(int[] a3 : a2)
                    Arrays.fill(a3, -1);

        int len = num.length();
        int[] d = new int[len];

        for(int i = 0; i < len; i++) 
            d[i] = num.charAt(i) - '0';

        int firstZero = len;

        for(int i = 0; i < len; i++) 
        {
            if (d[i] == 0) 
            { 
                firstZero = i; 
                break; 
            }
        }

        int[] p2 = new int[len + 1], p3 = new int[len + 1], p5 = new int[len + 1], p7 = new int[len + 1];
        for(int i = 0; i < len; i++) 
        {
            int[] c = cnt[d[i]];
            p2[i + 1] = p2[i] + c[0];
            p3[i + 1] = p3[i] + c[1];
            p5[i + 1] = p5[i] + c[2];
            p7[i + 1] = p7[i] + c[3];
        }


        if(firstZero == len) 
        { 
            if(p2[len] >= N2 && p3[len] >= N3 && p5[len] >= N5 && p7[len] >= N7)
            {
                return num;
            }
        }

        int limitI = Math.min(len - 1, firstZero);

        for(int i = limitI; i >= 0; i--) 
        {
            int r2 = N2 - p2[i];
            int r3 = N3 - p3[i];
            int r5 = N5 - p5[i];
            int r7 = N7 - p7[i];
            int suffixLen = len - i - 1;
            
            for(int dig = d[i] + 1; dig <= 9; dig++)
            {
                int nr2 = r2 - cnt[dig][0];
                int nr3 = r3 - cnt[dig][1];
                int nr5 = r5 - cnt[dig][2];
                int nr7 = r7 - cnt[dig][3];
                
                if(minDigits(nr2, nr3, nr5, nr7) <= suffixLen) 
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + dig));
                    appendGreedy(sb, nr2, nr3, nr5, nr7, suffixLen);
                    return sb.toString();
                }
            }
        }

        int need = minDigits(N2, N3, N5, N7);
        int L = Math.max(len + 1, need);
        StringBuilder sb = new StringBuilder();
        appendGreedy(sb, N2, N3, N5, N7, L);
        return sb.toString();
    }
}