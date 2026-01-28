class Solution {
    public String removeOccurrences(String s, String part) {
        
        StringBuilder res = new StringBuilder(s);

        while(res.toString().contains(part))
        {
            res.delete(res.indexOf(part), res.indexOf(part) + part.length());
        }

        return res.toString();
    }
}