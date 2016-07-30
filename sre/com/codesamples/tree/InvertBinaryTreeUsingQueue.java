public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        ArrayDeque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        myQueue.add(root);
        
        while(!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null) {
                myQueue.add(node.left);
            }
            if(node.right != null) {
                myQueue.add(node.right);
            }
        }
        return root;
    }
}
