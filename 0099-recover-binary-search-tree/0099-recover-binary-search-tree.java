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
    public void inorderUtil (TreeNode root, Queue <Integer> inorder, boolean put) {
        if (root == null)
            return;
        
        inorderUtil (root.left, inorder, put);
        if (put)
            root.val = inorder.poll ();
        else
            inorder.offer (root.val);
        inorderUtil (root.right, inorder, put);
    }
    
    public void recoverTree (TreeNode root) {
        Queue <Integer> inorder = new PriorityQueue <>();
        inorderUtil (root, inorder, false);
        inorderUtil (root, inorder, true);
    }
}