
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;

                if (need % 2 != 0) {
                    ans++;
                    need--;
                }
            } else {
                need--;

                if (need < 0) {
                    ans++;
                    need = 1;
                }
            }
        }

        return ans + need;
    }
}
