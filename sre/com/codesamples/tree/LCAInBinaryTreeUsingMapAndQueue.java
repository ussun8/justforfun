//Leetcode-236

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        queue.add(root);
        map.put(root,null);
        
        while(!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.pop();
            if(node.left != null) {
                queue.add(node.left);
                map.put(node.left,node);
            }
            if(node.right != null) {
                queue.add(node.right);
                map.put(node.right,node);
            }
        }
        Set<TreeNode> nodeSet = new HashSet<>();
        while(p!=null) {
            nodeSet.add(p);
            p = map.get(p);
        }
        while(!nodeSet.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}
