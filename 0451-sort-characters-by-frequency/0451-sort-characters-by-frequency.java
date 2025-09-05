class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();
        List<Character> temp = new ArrayList<>(map.keySet());
        temp.sort((ob1, ob2) -> map.get(ob2) - map.get(ob1));

        for(char ch : temp)
        {
            for(int i = 0; i < map.get(ch); i++)
            {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}