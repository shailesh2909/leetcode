class Solution {

    HashSet<String> set = new HashSet<>();

    public void solve(String s, int index, int left, int right, int count, String curr) {

        if(index == s.length()) {
            if(left == 0 && right == 0 && count == 0) {
                set.add(curr);
            }
            return;
        }

        char ch = s.charAt(index);

        if(ch == '(') {

            if(left > 0) {
                solve(s, index + 1, left - 1, right, count, curr);
            }

            solve(s, index + 1, left, right, count + 1, curr + ch);
        }

        else if(ch == ')') {

            if(right > 0) {
                solve(s, index + 1, left, right - 1, count, curr);
            }

            if(count > 0) {
                solve(s, index + 1, left, right, count - 1, curr + ch);
            }
        }

        else {
            solve(s, index + 1, left, right, count, curr + ch);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        for(char ch : s.toCharArray()) {

            if(ch == '(') {
                left++;
            }
            else if(ch == ')') {
                if(left > 0) {
                    left--;
                }
                else {
                    right++;
                }
            }
        }

        solve(s, 0, left, right, 0, "");

        return new ArrayList<>(set);
    }
}