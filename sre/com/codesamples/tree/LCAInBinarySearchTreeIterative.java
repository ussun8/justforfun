//Leetcode-

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if((root.val - p.val) * (root.val - q.val) < 1) {
                return root;
            }
            if(root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
