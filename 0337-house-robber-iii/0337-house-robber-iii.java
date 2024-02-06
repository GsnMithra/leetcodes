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
    Map <Pair <TreeNode, Boolean>, Integer> dp;
    public int robUtil (TreeNode root, boolean canRob) {
        if (root == null)
            return 0;
        if (dp.containsKey (new Pair <>(root, canRob)))
            return dp.get (new Pair <>(root, canRob));
        
        int take = 0, skip = 0;
        if (canRob)
            take = root.val + robUtil (root.left, false) + robUtil (root.right, false);
        skip = robUtil (root.left, true) + robUtil (root.right, true);
        
        dp.put (new Pair <>(root, canRob), Math.max (take, skip));
        return dp.get (new Pair <>(root, canRob));
    }
    
    public int rob (TreeNode root) {
        this.dp = new HashMap <>(); 
        return Math.max (robUtil (root, true), robUtil (root, false));
    }
}