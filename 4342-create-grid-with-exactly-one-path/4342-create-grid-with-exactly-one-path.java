class Solution {
    public String[] createGrid(int m, int n) {

        String[] ans = new String[m];

        for(int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '#');

            if(i == 0) {
                Arrays.fill(arr, '.');
            } else {
                arr[n - 1] = '.';
            }

            ans[i] = new String(arr);
        }

        return ans;
    }
}