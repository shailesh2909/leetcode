import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (charToWord.containsKey(currentChar)) {
                if (!charToWord.get(currentChar).equals(currentWord)) {
                    return false;
                }
            } else {
                charToWord.put(currentChar, currentWord);
            }

            if (wordToChar.containsKey(currentWord)) {
                if (wordToChar.get(currentWord) != currentChar) {
                    return false;
                }
            } else {
                wordToChar.put(currentWord, currentChar);
            }
        }

        return true;
    }
}
