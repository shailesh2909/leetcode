class Solution {

    public void solve(int n, char[] nums, StringBuilder str, List<String> list)
    {

        if(str.length() == n)
        {
            list.add(str.toString());
            return;
        }

        for(char ch : nums)
        {
            if(str.length() == 0 || str.charAt(str.length() - 1) != ch)
            {
                str.append(ch);
                solve(n, nums, str, list);
                str.deleteCharAt(str.length() - 1);
            }
        }
        
    }

    public String getHappyString(int n, int k) {

        List<String> list = new ArrayList<>();
        char nums[] = {'a', 'b', 'c'};

        solve(n, nums, new StringBuilder(), list);

        return list.size() < k ? "" : list.get(k - 1);
    }
}