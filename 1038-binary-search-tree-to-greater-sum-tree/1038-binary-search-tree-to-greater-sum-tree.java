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
    int j;
    public void inorderUtil (TreeNode root, List <Integer> inorder, boolean set) {
        if (root == null)
            return;
        
        inorderUtil (root.right, inorder, set);
        if (set) {
            root.val = inorder.get (j);
            j += 1;
        }
        else
            inorder.add (root.val);
        inorderUtil (root.left, inorder, set);
    }
    
    public TreeNode bstToGst (TreeNode root) {
        List <Integer> inorder = new ArrayList <>();
        inorderUtil (root, inorder, false);
        j = 0;
        
        int runningSum = 0;
        for (int i = 0; i < inorder.size (); i += 1) {
            runningSum += inorder.get (i);
            inorder.set (i, runningSum);
        }
        
        inorderUtil (root, inorder, true);
        return root;
    }
}