class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int leftSum = 0;

        for(int i = 0; i < k; i++)
        {
            leftSum += cardPoints[i];
        }

        int rightSum = 0;
        int maxSum = leftSum;

        for(int i = 0; i < k; i++)
        {
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[n - 1 - i];

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}