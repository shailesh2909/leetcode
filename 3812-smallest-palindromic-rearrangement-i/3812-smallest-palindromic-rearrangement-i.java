class Solution {
    public String smallestPalindrome(String s) {
        
        int[] arr = new int[26];

        for(char ch : s.toCharArray())
        {
            arr[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for(int i = 0; i < 26; i++)
        {
            for(int j = 0; j < arr[i] / 2; j++)
            {
                left.append((char)('a' + i));
            }

            if(arr[i] % 2 == 1)
            {
                mid.append((char)('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();

        
    }
}