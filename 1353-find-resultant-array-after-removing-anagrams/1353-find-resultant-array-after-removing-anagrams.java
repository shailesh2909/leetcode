class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> ans = new ArrayList<>();

        int arr[] = new int[words.length];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] =  0;
        }

        for(int i = 0; i < words.length - 1 ; i++)
        {
            boolean flag = true;

            int[] fr1 = new int[26];

            for(char ch : words[i].toCharArray())
            {
                fr1[ch - 'a']++;
            }

            for(char ch : words[i+1].toCharArray())
            {
                fr1[ch - 'a']--;
            }

            for(int j = 0; j < 26; j++)
            {
                if(fr1[j] != 0)
                {
                    flag = false;
                    break;
                }
            }

            if(flag == true)
            {
                arr[i+1] = 1;
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0)
            {
                ans.add(words[i]);
            }
        }

        return ans;
    }
}