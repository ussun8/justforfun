/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private ArrayDeque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        populateStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        populateStack(node.right);
        return val;
    }
    
    private void populateStack(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
