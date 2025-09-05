class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
        {
            return false;
        }
        
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        for(int i = 0; i < s.length(); i++)
        {
            char ch = t.charAt(i);
            arr[ch-'a']--;;
            if(arr[ch-'a'] < 0) return false;
        }

        return true;
    }
}