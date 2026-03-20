class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int freq[] = new int[26];

        for(char ch : tasks)
        {
            freq[ch - 'A']++;
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int fr : freq)
        {
            maxFreq = Math.max(maxFreq, fr);
        }

        int countMax = 0;
        for(int ele : freq)
        {
            if(ele == maxFreq)
            {
                countMax++;
            }
        }

        int part = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(tasks.length, part);
    }
}