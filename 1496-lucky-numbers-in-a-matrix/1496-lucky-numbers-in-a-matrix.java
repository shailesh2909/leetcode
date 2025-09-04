class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int minVal = Integer.MAX_VALUE;
            int colIndex = -1;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][colIndex] > minVal) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) ans.add(minVal);
        }

        return ans;
    }
}
