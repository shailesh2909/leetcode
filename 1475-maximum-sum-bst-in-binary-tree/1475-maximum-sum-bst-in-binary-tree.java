/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Info
{
    int min, max, sum;
    boolean isBST;

    Info(int min, int max, int sum, boolean isBst)
    {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBst;
    }
}

class Solution {

    int maxSum = 0;

    public Info solve(TreeNode root)
    {
        if(root == null)
        {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) 
        {
            int sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);

            return new Info(
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                sum,
                true
            );
        }

        return new Info(0, 0, 0, false);
    }
    public int maxSumBST(TreeNode root) {

        solve(root);
        return maxSum;
    }
}