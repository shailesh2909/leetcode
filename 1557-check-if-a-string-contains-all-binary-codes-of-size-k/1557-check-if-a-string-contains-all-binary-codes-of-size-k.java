class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) return false;

        Set<String> foundCodes = new HashSet<>();
        int totalNeeded = 1 << k;
        
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            foundCodes.add(sub);
            
            if (foundCodes.size() == totalNeeded) return true;
        }

        return foundCodes.size() == totalNeeded;
    }
}