/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }
    
    public TreeNode invertTreeHelper(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode tmpLeft = node.left;
        node.left = invertTreeHelper(node.right);
        node.right = invertTreeHelper(tmpLeft);
        return node;
    }
}
