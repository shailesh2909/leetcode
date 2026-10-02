class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int freq[] = new int[26];

        for(char c : s1.toCharArray())
        {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while(right < s2.length())
        {
            int index = s2.charAt(right) - 'a';

            if(freq[index] > 0)
            {
                freq[index]--;
                count++;
                right++;

                if(count == s1.length())
                {
                    return true;
                }
            }
            else
            {
                int leftIndex = s2.charAt(left) - 'a';

                freq[leftIndex]++;
                left++;
                count--;
            }
        }

        return false;
    }
}