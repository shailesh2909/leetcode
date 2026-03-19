class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < t.length(); i++)
        {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int need = tmap.size();
        int have = 0;
        int start = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if(tmap.containsKey(c) && smap.get(c).equals(tmap.get(c)))
            {
                have++;
            }

            while(have == need)
            {
                if((right - left + 1) < min)
                {
                    min = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                smap.put(leftChar, smap.get(leftChar) - 1);

                if(tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar))
                {
                    have--;
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}