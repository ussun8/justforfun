//Leetcode-236

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root == null) || (root == p) || (root == q)) {
            return root;
        }
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
        if(leftFound != null && rightFound != null) {
            return root;
        }
        return (leftFound != null) ? leftFound : rightFound;
    }
}
