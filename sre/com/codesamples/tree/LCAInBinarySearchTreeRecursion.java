//Leetcode-235

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        return lcaHelper(root, p, q);
    }
    
    public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(((root.val - p.val) * (root.val - q.val)) < 1) {
            return root;
        }
        
        return (root.val < p.val) ? lcaHelper(root.right, p, q) : 
            lcaHelper(root.left, p, q);
    }
}
