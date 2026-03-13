class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        String res = s;
        
        q.offer(s);
        vis.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                int d = (arr[i] - '0' + a) % 10;
                arr[i] = (char)(d + '0');
            }
            String add = new String(arr);
            if (!vis.contains(add)) {
                vis.add(add);
                q.offer(add);
            }
            
            String rot = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (!vis.contains(rot)) {
                vis.add(rot);
                q.offer(rot);
            }
        }
        
        return res;
    }
}