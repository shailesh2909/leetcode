class Solution {

    public void solve(String digits, int index, StringBuilder output, List<String> ans, String[] mapping)
    {
        if(index == digits.length())
        {
            ans.add(output.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String value = mapping[num];

        for(int i = 0; i < value.length(); i++)
        {
            output.append(value.charAt(i));
            solve(digits, index + 1, output, ans, mapping);
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, 0, new StringBuilder(), ans, mapping);

        return ans;
    }
}
