class Solution {

    List<List<String>> ans;
    HashMap<String, Integer> map;

    private void dfs(String word, List<String> seq) {

        if (map.get(word) == 1) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = map.get(word);
        int sz = word.length();

        for (int i = 0; i < sz; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {

                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);

                if (map.containsKey(replacedWord) && map.get(replacedWord) == steps - 1) {
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        ans = new ArrayList<>();
        map = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord, 1);

        int sz = beginWord.length();
        set.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = map.get(word);

            if (word.equals(endWord)) break;

            for (int i = 0; i < sz; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (set.contains(replacedWord)) {
                        q.add(replacedWord);
                        set.remove(replacedWord);
                        map.put(replacedWord, steps + 1);
                    }
                }
            }
        }

        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}