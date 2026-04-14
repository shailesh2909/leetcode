class Pair
{
    String first;
    int second;

    Pair(String str, int steps)
    {
        first = str;
        second = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < wordList.size(); i++)
        {
            set.add(wordList.get(i));
        }

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int steps = q.peek().second;

            q.remove();
            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String temp = new String(arr);

                    if(set.contains(temp))
                    {
                        set.remove(temp);
                        q.add(new Pair(temp, steps + 1));
                    }
                }
            }
        }

        return 0;
        
    }
}