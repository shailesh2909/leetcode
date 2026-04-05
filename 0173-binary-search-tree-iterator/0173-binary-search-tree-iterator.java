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
class BSTIterator {
    
    TreeNode root;
    ArrayList<Integer> list; 
    int count;

    public BSTIterator(TreeNode root) {
        
        this.root = root;
        list = new ArrayList<>();
        count = 0;
        inorder(this.root, list);
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int next() {
        
        int ele = list.get(count);
        count++;
        return ele;
    }
    
    public boolean hasNext() {
        
        if(count >= list.size())
        {
            return false;
        }

        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */