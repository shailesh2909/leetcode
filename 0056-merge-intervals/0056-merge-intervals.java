import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> temp = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (temp.isEmpty() || intervals[i][0] > temp.get(temp.size() - 1)[1]) {
                temp.add(intervals[i]);
            } else {
                temp.get(temp.size() - 1)[1] = Math.max(temp.get(temp.size() - 1)[1], intervals[i][1]);
            }
        }

        return temp.toArray(new int[temp.size()][]);
    }
}
