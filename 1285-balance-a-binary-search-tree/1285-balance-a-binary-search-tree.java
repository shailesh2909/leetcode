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
class Solution {

    public TreeNode makeBST(ArrayList<Integer> list, int start, int end)
    {
        if(start > end)
        {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(list.get(mid));

        node.left = makeBST(list, start, mid - 1);
        node.right = makeBST(list, mid + 1, end);

        return node;
    }

    public void inorder(TreeNode node, ArrayList<Integer> res)
    {
        if(node == null)
        {
            return;
        }

        inorder(node.left, res);

        res.add(node.val);

        inorder(node.right, res);

    }

    public TreeNode balanceBST(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        inorder(root, res);

        return makeBST(res, 0, res.size() - 1);
        
    }
}