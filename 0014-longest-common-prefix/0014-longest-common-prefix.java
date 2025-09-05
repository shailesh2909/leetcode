class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder ans = new StringBuilder();

        Arrays.sort(strs);

        String str1 = strs[0];
        String str2 = strs[strs.length - 1];

        int ind = 0;

        while(ind < str1.length())
        {
            if(str1.charAt(ind) == str2.charAt(ind))
            {
                ind++;
            }
            else
            {
                break;
            }
        }

       return ind >= 0 ? str1.substring(0, ind) : "";

    }
}